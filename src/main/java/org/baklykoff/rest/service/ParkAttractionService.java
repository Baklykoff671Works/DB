package org.baklykoff.rest.service;

import org.baklykoff.rest.repository.ParkAttractionRepository;
import org.baklykoff.rest.models.ParkAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ParkAttractionService {

    @Autowired
    private ParkAttractionRepository parkAttractionRepository;

    public ParkAttraction addParkAttraction(final ParkAttraction parkAttraction) {
        return parkAttractionRepository.save(parkAttraction);
    }

    public ParkAttraction updateParkAttraction(final ParkAttraction parkAttraction) {
        return parkAttractionRepository.save(parkAttraction);
    }

    public List<ParkAttraction> getParkAttractions() {
        return parkAttractionRepository.findAll();
    }

    public ParkAttraction getParkAttractionById(final Integer id) {
        return parkAttractionRepository.findById(id).orElse(null);
    }

    public void deleteParkAttractionById(final Integer id) {
        parkAttractionRepository.deleteById(id);
    }
}
