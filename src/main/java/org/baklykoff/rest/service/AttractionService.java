package org.baklykoff.rest.service;

import org.baklykoff.rest.repository.AttractionRepository;
import org.baklykoff.rest.models.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class AttractionService {

    @Autowired
    private AttractionRepository attractionRepository;

    public Attraction addAttraction(final Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    public Attraction updateAttraction(final Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractionRepository.findAll();
    }

    public Attraction getAttractionById(final Integer id) {
        return attractionRepository.findById(id).orElse(null);
    }

    public void deleteAttractionById(final Integer id) {
        attractionRepository.deleteById(id);
    }
}
