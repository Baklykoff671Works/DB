package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.ShowEntertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowEntertainmentRepository extends JpaRepository<ShowEntertainment,Integer> {
}
