package com.myron.DojosAndNinjas.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myron.DojosAndNinjas.models.Ninja;
import com.myron.DojosAndNinjas.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaPageService {
	@Autowired 
    NinjaRepository ninjaRepo;

    // static variable to set the number of ninjas that we want per page
    private static final int PAGE_SIZE = 5;

    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "dojo.name");
        Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
        return ninjaRepo.findAll(pageRequest);
    }
}
