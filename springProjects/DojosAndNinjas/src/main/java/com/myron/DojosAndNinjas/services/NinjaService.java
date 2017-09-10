package com.myron.DojosAndNinjas.services;

import org.springframework.stereotype.Service;

import com.myron.DojosAndNinjas.models.Ninja;
import com.myron.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
}
