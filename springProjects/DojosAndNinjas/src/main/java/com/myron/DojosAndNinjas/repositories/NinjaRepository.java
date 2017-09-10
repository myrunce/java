package com.myron.DojosAndNinjas.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myron.DojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{
	
}
