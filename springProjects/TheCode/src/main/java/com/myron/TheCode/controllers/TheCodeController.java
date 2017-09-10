package com.myron.TheCode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TheCodeController {
	
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors, HttpSession session) {
		String the_word = "bushido";
		session.setAttribute("word", the_word);
		return "index.jsp";
	}
	
	@RequestMapping(path="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="guess") String guess, RedirectAttributes redirectAttributes, HttpSession session) {
		String the_word = (String) session.getAttribute("word");
		if (guess.equals(the_word)) {
			return "redirect:/code";
		}
		else {
			redirectAttributes.addFlashAttribute("errors", "You must train harder!");
			return "redirect:/";	
		}
	}
	
	@RequestMapping("/code")
	public String code() {
		return "codeView.jsp";
	}
}
