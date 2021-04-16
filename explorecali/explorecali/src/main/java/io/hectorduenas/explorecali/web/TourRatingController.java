package io.hectorduenas.explorecali.web;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.hectorduenas.explorecali.domain.Tour;
import io.hectorduenas.explorecali.domain.TourRating;
import io.hectorduenas.explorecali.domain.TourRatingPK;
import io.hectorduenas.explorecali.repo.TourRatingRepository;
import io.hectorduenas.explorecali.repo.TourRepository;

@RestController
@RequestMapping(path="/tours/{tourId}/ratings")
public class TourRatingController {
	
	TourRatingRepository tourRatingRepository;
	TourRepository tourRepository;
	
	@Autowired
	public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepository = tourRepository;
	}
	
	protected TourRatingController() {}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTourRating(@PathVariable(value="tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
		Tour tour = verifyTour(tourId);
		tourRatingRepository.save(new TourRating( new TourRatingPK(tour, ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));
	}

	private Tour verifyTour(int tourId) throws NoSuchElementException{
		return tourRepository.findById(tourId).orElseThrow(() -> new NoSuchElementException("Tour does not exist "+ tourId));
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();
	}
}
