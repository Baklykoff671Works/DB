package org.baklykoff.rest.service;

import org.baklykoff.rest.repository.ShowEntertainmentRepository;
import org.baklykoff.rest.models.ShowEntertainment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ShowEntertainmentService {

    @Autowired
    private ShowEntertainmentRepository showEntertainmentRepository;

    public ShowEntertainment addShowEntertainment(final ShowEntertainment showEntertainment) {
        return showEntertainmentRepository.save(showEntertainment);
    }

    public ShowEntertainment updateShowEntertainment(final ShowEntertainment showEntertainment) {
        return showEntertainmentRepository.save(showEntertainment);
    }

    public List<ShowEntertainment> getShowEntertainments() {
        return showEntertainmentRepository.findAll();
    }

    public ShowEntertainment getShowEntertainmentById(final Integer id) {
        return showEntertainmentRepository.findById(id).orElse(null);
    }

    public void deleteShowEntertainmentById(final Integer id) {
        showEntertainmentRepository.deleteById(id);
    }
}
