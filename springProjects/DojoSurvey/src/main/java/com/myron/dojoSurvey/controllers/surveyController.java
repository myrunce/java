package com.myron.dojoSurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class surveyController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="name") String name, @RequestParam(value="dojoLocation") String location, @RequestParam(value="favLanguage") String language, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String results(HttpSession session) {
		return "resultsView.jsp";
	}
}
