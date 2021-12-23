package org.baklykoff.rest.service;

import org.baklykoff.rest.repository.ParkRepository;
import org.baklykoff.rest.models.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;

    public Park addPark(final Park park) {
        return parkRepository.save(park);
    }

    public Park updatePark(final Park park) {
        return parkRepository.save(park);
    }

    public List<Park> getParks() {
        return parkRepository.findAll();
    }

    public Park getParkById(final Integer id) {
        return parkRepository.findById(id).orElse(null);
    }

    public void deleteParkById(final Integer id) {
        parkRepository.deleteById(id);
    }
}
