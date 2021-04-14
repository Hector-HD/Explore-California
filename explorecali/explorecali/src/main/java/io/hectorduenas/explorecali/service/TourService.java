package io.hectorduenas.explorecali.service;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;

import io.hectorduenas.explorecali.domain.Difficulty;
import io.hectorduenas.explorecali.domain.Tour;
import io.hectorduenas.explorecali.domain.TourPackage;
import io.hectorduenas.explorecali.repo.TourPackageRepository;
import io.hectorduenas.explorecali.repo.TourRepository;

public class TourService {
	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public Tour createTour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String tourPackageName, Difficulty difficulty, Region region) {
		
		TourPackage tourPackage = tourPackageRepository.findById(tourPackageName)
				.orElseThrow(() -> new RuntimeException("Tour package does not exist" +  tourPackageName));
		
		return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, tourPackage, difficulty, region));
	}
	
	public long total() { return tourRepository.count(); } 
}
