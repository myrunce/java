package com.myron.ForTran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForTranController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
	public String first(@PathVariable int chapter, @PathVariable String assignmentNumber) {
		String the_link = ""; 
		if (chapter == 38 && assignmentNumber.equals("0345")) {
			String link = "assignment.jsp";
			the_link = link;
		}
		else if (chapter == 26 && assignmentNumber.equals("2342")) {
			String link =  "assignment.jsp";
			the_link = link;
		}
		return the_link;
	}
	
	@RequestMapping("/m/{chapter}/0553/{assignmentNumber}")
	public String last(@PathVariable int chapter, @PathVariable String assignmentNumber) {
		String the_link = ""; 
		if (chapter == 38 && assignmentNumber.equals("0733")) {
			String link = "lesson.jsp";
			the_link = link;
		}
		else if (chapter == 38 && assignmentNumber.equals("0342")) {
			String link =  "lesson.jsp";
			the_link = link;
		}
		else if (chapter == 26 && assignmentNumber.equals("0348")) {
			String link =  "lesson.jsp";
			the_link = link;
		}
		return the_link;
	}
}
