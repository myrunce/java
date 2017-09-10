package com.myron.displayDate.controllers;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "forward:/index.html";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		model.addAttribute("date", date);
		return "dateView.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		model.addAttribute("date", date);
		return "timeView.jsp";
	}
}
