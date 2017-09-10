package com.myron.DojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myron.DojosAndNinjas.models.Dojo;
import com.myron.DojosAndNinjas.models.Ninja;
import com.myron.DojosAndNinjas.services.DojoService;
import com.myron.DojosAndNinjas.services.NinjaPageService;
import com.myron.DojosAndNinjas.services.NinjaService;

@Controller
public class DojosAndNinjasController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	private final NinjaPageService pageService;
	
	public DojosAndNinjasController(DojoService dojoService, NinjaService ninjaService, NinjaPageService pageService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
		this.pageService = pageService;
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/add")
	public String makeDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/dojos/new";
        }else{
            dojoService.addDojo(dojo);
            return "redirect:/dojos/new";
        }
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		List<Dojo> dojos = dojoService.alldojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/add")
	public String makeNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
            return "redirect:/ninjas/new";
        }else{
        	System.out.println("ADDING NINJA");
            ninjaService.addNinja(ninja);
            return "redirect:/ninjas/new";
        }
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoNinjas(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.findDojoById(id);
		List<Ninja> ninjas = dojo.getNinjas();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojo", dojo);
		return "dojoNinjas.jsp";
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
	    Page<Ninja> ninjas = pageService.ninjasPerPage(pageNumber - 1);

	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}
}
