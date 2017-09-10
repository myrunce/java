package com.myron.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.DojosAndNinjas.models.Dojo;
import com.myron.DojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	public List<Dojo> alldojos(){
		return (List<Dojo>) dojoRepository.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		return dojoRepository.findOne(id);
	}
	
}
