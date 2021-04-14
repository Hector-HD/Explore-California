package io.hectorduenas.explorecali.service;

import org.springframework.beans.factory.annotation.Autowired;

import io.hectorduenas.explorecali.domain.TourPackage;
import io.hectorduenas.explorecali.repo.TourPackageRepository;

public class TourPackageService {
	
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {
		return tourPackageRepository.findById(code)
				.orElse(tourPackageRepository.save(new TourPackage(code, name)));
	}
	
	public Iterable<TourPackage> lookup(){ 
		return tourPackageRepository.findAll(); 
	}
	
	public long total() { return tourPackageRepository.count(); }
}
