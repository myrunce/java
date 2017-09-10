package com.myron.counter.controllers;

import static org.mockito.Matchers.intThat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			int counter = 1;
			session.setAttribute("counter", counter);
		}
		else {
			int counter = (int) session.getAttribute("counter");
			counter++;
			session.setAttribute("counter", counter);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		return "counterView.jsp";
	}
}
