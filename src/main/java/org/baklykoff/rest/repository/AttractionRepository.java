package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.Attraction;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction,Integer> {

}