package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.ParkAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkAttractionRepository extends JpaRepository<ParkAttraction,Integer> {
}
