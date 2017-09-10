package com.myron.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class portfolioController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}
}
