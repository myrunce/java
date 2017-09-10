package com.myron.Relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myron.Relationships.models.License;
import com.myron.Relationships.models.Person;
import com.myron.Relationships.services.LicenseService;
import com.myron.Relationships.services.PersonService;

@Controller
public class RelationshipController {
private final LicenseService licenseService;
private final PersonService personService;

	public RelationshipController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		return "newPerson.jsp";
	}
	
	@PostMapping("/persons/add")
	public String makePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/persons/new";
        }else{
            personService.addPerson(person);
            return "redirect:/persons/new";
        }
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		try {
			List<Person> persons = (List<Person>) personService.allPersons();
			int id = licenseService.getTheLastId();
			String number = String.format("%06d", id);
			model.addAttribute("persons", persons);
			model.addAttribute("id", number);
			return "newLicense.jsp";
		}
		catch(NullPointerException e){
			List<Person> persons = (List<Person>) personService.allPersons();
			int id = 1;
			String number = String.format("%06d", id);
			model.addAttribute("persons", persons);
			model.addAttribute("id", number);
			return "newLicense.jsp";
		}
	}
	
	@PostMapping("/licenses/add")
	public String makeLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
            return "newLicense.jsp";
        }else{
            licenseService.addLicense(license);
            return "redirect:/licenses/new";
        }
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(Model model, @PathVariable("id") Long id) {
		License license = licenseService.findLicensebyId(id);
		model.addAttribute("license", license);
		return "showPerson.jsp";
	}
}
