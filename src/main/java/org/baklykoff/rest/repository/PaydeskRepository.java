package org.baklykoff.rest.repository;

import org.baklykoff.rest.models.Paydesk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaydeskRepository extends JpaRepository<Paydesk,Integer> {
}
