package com.myron.DojoOverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myron.DojoOverflow.models.Answer;
import com.myron.DojoOverflow.models.Question;
import com.myron.DojoOverflow.models.Tag;
import com.myron.DojoOverflow.services.AnswerService;
import com.myron.DojoOverflow.services.QuestionService;
import com.myron.DojoOverflow.services.TagService;

@Controller
public class DojoOverflowController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
	
	public DojoOverflowController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}
	
	@RequestMapping("/questions")
	public String questions(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("theQuestion") Question question, @ModelAttribute("errors") String errors, Model model) {
		model.addAttribute("errors", errors);
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/add")
	public String addQuestion(@Valid @ModelAttribute("theQuestion") Question question, BindingResult result, @RequestParam("subject") String subject, RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
            return "newQuestion.jsp";
		}
		else if (subject.length() < 1) {
			redirectAttributes.addFlashAttribute("errors", "Tags cannot be blank!");
			return "redirect:/questions/new";
		}
		else{
        	System.out.println("ADDING QUESTION");
        	questionService.addQuestion(question);
        	List<Tag> allTags = new ArrayList<Tag>();
        	String[] words = subject.split(", ");
        	for (int i = 0; i < words.length; i++){
        		Tag tag = tagService.findTagBySubject(words[i]);
        		if (tag != null) {
        			allTags.add(tag);
        		} else {
        			allTags.add(new Tag(words[i]));
        		}
        	}
        	question.setTags(allTags);
        	questionService.updateQuestion(question);
        	return "redirect:/questions/" + question.getId();
        }
	}
	
	@GetMapping("questions/{id}")
	public String questionProfile(
			@PathVariable("id") Long id,
			@ModelAttribute("a") Answer answer,
			Model model) {
		Question question = questionService.findQuestionById(id);
		model.addAttribute("question", question);
		model.addAttribute("answers", answerService.getAnswersForQuestion(question));
		return "questionprofile.jsp";
	}
	
	@PostMapping("questions/{id}")
	public String addAnswerToQuestion(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("a") Answer answer,
			BindingResult result,
			Model model) {
		Question question = questionService.findQuestionById(id);
		model.addAttribute("question", question);
		model.addAttribute("answers", answerService.getAnswersForQuestion(question));
		if (result.hasErrors()) {
			return "questionprofile.jsp";
		} else {
			answerService.addAnswer(answer);
			return "redirect:/questions/" + id;
		}
	}
}
