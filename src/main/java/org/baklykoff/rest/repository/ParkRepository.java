package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepository extends JpaRepository<Park,Integer> {
}
