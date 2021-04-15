package io.hectorduenas.explorecali.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.hectorduenas.explorecali.domain.TourPackage;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{
	Optional<TourPackage> findByName(String name);
}
