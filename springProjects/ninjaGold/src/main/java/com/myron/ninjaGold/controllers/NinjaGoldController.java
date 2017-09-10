package com.myron.ninjaGold.controllers;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			int gold = 0;
			session.setAttribute("gold", gold);
		}
		if (session.getAttribute("messages") == null) {
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
		}
		ArrayList<String> listedMessages = new ArrayList<String>();
		listedMessages = (ArrayList<String>)session.getAttribute("messages");
		model.addAttribute("messages", listedMessages);
		return "index.jsp";
	}
	
	@RequestMapping(path="/process_money", method=RequestMethod.POST)
	public String process_money(@RequestParam(value="building") String building, HttpSession session, Model model) {
		String location = building;
		int the_gold = 0;
		if (location.equals("farm")) {
			Random r = new Random();
			int high = 21;
			int low = 10;
			int gold_earned = r.nextInt(high - low) + low;
			the_gold = gold_earned;
			int gold = (int)session.getAttribute("gold") + gold_earned;
			session.setAttribute("gold", gold);
		}
		else if (location.equals("cave")) {
			Random r = new Random();
			int high = 11;
			int low = 5;
			int gold_earned = r.nextInt(high - low) + low;
			the_gold = gold_earned;
			int gold = (int)session.getAttribute("gold") + gold_earned;
			session.setAttribute("gold", gold);
		}
		else if (location.equals("house")) {
			Random r = new Random();
			int high = 6;
			int low = 2;
			int gold_earned = r.nextInt(high - low) + low;
			the_gold = gold_earned;
			int gold = (int)session.getAttribute("gold") + gold_earned;
			session.setAttribute("gold", gold);
		}
		else if (location.equals("casino")) {
			Random r = new Random();
			int high = 50;
			int low = -50;
			int gold_earned = r.nextInt(high - low) + low;
			the_gold = gold_earned;
			int gold = (int)session.getAttribute("gold") + gold_earned;
			session.setAttribute("gold", gold);
		}
		if (the_gold < 0) {
			String color = "red";
			Date date = new Date();
			String message = "Entered a casino and lost " + the_gold + " gold...ouch " + date;
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(message);
			session.setAttribute("messages", messages);
			model.addAttribute("color", color);
		}
		else {
			String color = "green";
			Date date = new Date();
			String message = "Earned " + the_gold + " gold from the " + location + "! " + date;
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			messages.add(message);
			session.setAttribute("messages", messages);
			model.addAttribute("color", color);
		}
		return "redirect:/";
	}
}
