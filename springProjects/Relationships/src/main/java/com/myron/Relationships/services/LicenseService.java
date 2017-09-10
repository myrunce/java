package com.myron.Relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myron.Relationships.models.License;
import com.myron.Relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	}
	
	public List<License> allSongs() {
		return (List<License>) licenseRepository.findAll();
	}
	
	public License findLicensebyId(Long id) {
		return licenseRepository.findOne(id);
	}
	
	public int getTheLastId() {
		License license = licenseRepository.findFirstByOrderByIdDesc();
		Long temp = license.getId() + 1;
		int id = temp.intValue();
		return id;
	}
}
