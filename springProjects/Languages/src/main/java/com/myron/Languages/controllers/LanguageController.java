package com.myron.Languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myron.Languages.models.Language;
import com.myron.Languages.services.LanguageService;


@Controller
@SuppressWarnings("unused")

public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		if (result.hasErrors()) {
    		return "index.jsp";
    	}
    	else {
    		languageService.addLanguage(language);
    		return "redirect:/";
    	}
	}
	   
    @RequestMapping("/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguageById(id);
        if (language != null){
            model.addAttribute("language", language);
            model.addAttribute("id", id);
            return "editLangauge.jsp";
        }else{
            return "redirect:/";
        }
    }
    
    @PostMapping("/edit/{id}")
    public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "editLanguage.jsp";
        }else{
            languageService.updateLanguage(language);
            return "redirect:/";
        }
    }
    
    @RequestMapping("/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/";
    }
    
    @RequestMapping("/language/{index}")
    public String findLanguageByIndex(Model model, @PathVariable("index") Long index) {
        Language language = languageService.findLanguageById(index);
        model.addAttribute("language", language);
        model.addAttribute("id", index);
        return "showLanguage.jsp";
    }
}
