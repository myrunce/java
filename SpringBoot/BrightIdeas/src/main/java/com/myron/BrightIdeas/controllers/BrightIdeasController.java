package com.myron.BrightIdeas.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myron.BrightIdeas.models.Idea;
import com.myron.BrightIdeas.models.Role;
import com.myron.BrightIdeas.models.User;
import com.myron.BrightIdeas.services.IdeaService;
import com.myron.BrightIdeas.services.UserService;
import com.myron.BrightIdeas.validator.UserValidator;

@Controller
public class BrightIdeasController {
	private final UserService userService;
    private final UserValidator userValidator;
    private final IdeaService ideaService;
     
    
    public BrightIdeasController(UserService userService, UserValidator userValidator, IdeaService ideaService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.ideaService = ideaService;
    }

	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        // NEW
		userValidator.validate(user, result);
        if (result.hasErrors()) {
        	System.out.println(result);
            return "loginPage.jsp";
        }
        System.out.println("making user...");
        userService.saveWithUserRole(user);
        return "redirect:/";
    }


	@RequestMapping("/")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @Valid @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
        return "loginPage.jsp";
    }
	
    @RequestMapping("/bright_idea")
    public String home(Principal principal, Model model, @Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("ideas", ideaService.allIdeas());
        return "brightIdea.jsp";
    }
    
    @PostMapping("/bright_idea")
    public String postIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Principal principal) {
    	if (result.hasErrors()) {
    		return "redirect:/bright_idea";
    	}
    	else {
    		String username = principal.getName();
    		User user = userService.findByUsername(username);
    		idea.setAuthor(user);
    		ideaService.addIdea(idea);
    		return "redirect:/bright_idea";
    	}
    }
    
    @RequestMapping("/like/{id}")
    public String likeIdea(@PathVariable("id") Long id, Principal principal) {
    	Idea idea = ideaService.findIdea(id);
    	String username = principal.getName();
		User user = userService.findByUsername(username);
		List<User> likes = idea.getLikes();
		likes.add(user);
		idea.setLikes(likes);
		ideaService.updateIdea(idea);
		return "redirect:/bright_idea";
    }
    
    @RequestMapping("/unlike/{id}")
    public String unlikeIdea(@PathVariable("id") Long id, Principal principal) {
    	Idea idea = ideaService.findIdea(id);
    	String username = principal.getName();
		User user = userService.findByUsername(username);
		List<User> likes = idea.getLikes();
		likes.remove(user);
		idea.setLikes(likes);
		ideaService.updateIdea(idea);
		return "redirect:/bright_idea";
    }
    @RequestMapping("/users/{id}")
    public String user(@PathVariable("id") Long id, Model model){
    	User user = userService.findById(id);
    	model.addAttribute("user", user);
    	List<Idea> ideas = new ArrayList<Idea>();
    	ideas = ideaService.findAllByAuthor(user);
    	int likes = 0;
    	for (int i = 0; i < ideas.size(); i++) {
    		likes += ideas.get(i).getLikes().size();
    	}
    	model.addAttribute("likes", likes);
    	model.addAttribute("posts", ideas.size());
    	return "user.jsp";
    }
    
    @RequestMapping("/bright_ideas/{id}")
    public String oneIdea(@PathVariable("id") Long id, Model model) {
    	Idea idea = ideaService.findIdea(id);
    	model.addAttribute("idea", idea);
    	return "idea.jsp";
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteIdea(@PathVariable("id") Long id) {
    	ideaService.deleteIdea(ideaService.findIdea(id));
    	return "redirect:/bright_idea";
    }
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.findAll());
        return "adminPage.jsp";
    }    
}
