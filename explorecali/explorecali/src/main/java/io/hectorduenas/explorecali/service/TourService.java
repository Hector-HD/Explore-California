package io.hectorduenas.explorecali.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hectorduenas.explorecali.domain.Tour;
import io.hectorduenas.explorecali.domain.TourPackage;
import io.hectorduenas.explorecali.repo.TourPackageRepository;
import io.hectorduenas.explorecali.repo.TourRepository;

@Service
public class TourService {
	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}
    
	 public Tour createTour(String title, String tourPackageName, Map<String,String> details ) {
	TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(()->
	new RuntimeException("Tour package does not exist: " + tourPackageName));
	
	return tourRepository.save(new Tour(title, tourPackage, details));
	}
	
	public long total() { return tourRepository.count(); }
}
