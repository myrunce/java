package com.myron.Auth.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myron.Auth.models.Role;
import com.myron.Auth.models.User;
import com.myron.Auth.services.UserService;
import com.myron.Auth.validator.UserValidator;

@Controller
public class Users {
	private UserService userService;
    private UserValidator userValidator;
     
    @Autowired
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
//    public Users() {
//    	
//    }

	public Users(UserService userService) {
		this.userService = userService;
	}

//	@RequestMapping("/registration")
//	public String registerForm(@Valid @ModelAttribute("user") User user) {
//		return "registrationPage.jsp";
//	}

	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        // NEW
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "loginPage.jsp";
        }
        List<User> users = userService.findAll();
        System.out.println(users.size());
        if (users.size() == 0) {
        	System.out.println("SAVING AS ADMIN");
        	userService.saveUserWithAdminRole(user);
        	return "redirect:/admin";
        }
        else {
        	System.out.println("ELSE STATEMENT");
        	int counter = 0;
        	for(int i = 0; i < users.size(); i++) {
        		List<Role> roles = users.get(i).getRoles();
        		System.out.println(roles);
        		for(int j = 0; j < roles.size(); j++) {
        			String theRole = (String) roles.get(j).getName();
        			System.out.println(theRole);
        			if (theRole.equals("ROLE_ADMIN")) {
        				counter++;
        			}
        		}
        	}
        	if (counter > 0) {
        		userService.saveWithUserRole(user);
        		return "redirect:/login";
        	}
        	else {
        		userService.saveUserWithAdminRole(user);
            	return "redirect:/admin";
        	}
        }
    }


	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @Valid @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
        return "loginPage.jsp";
    }
	
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, HttpSession session) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        session.setAttribute("signIn", new Date());
        return "homePage.jsp";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.findAll());
        return "adminPage.jsp";
    }
}