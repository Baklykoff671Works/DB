package org.baklykoff.rest.service;

import org.baklykoff.rest.models.Visitor;
import org.baklykoff.rest.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public Visitor addVisitor(final Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public Visitor updateVisitor(final Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    public List<Visitor> getVisitors() {
        return visitorRepository.findAll();
    }

    public Visitor getVisitorById(final Integer id) {
        return visitorRepository.findById(id).orElse(null);
    }

    public void deleteVisitorById(final Integer id) {
        visitorRepository.deleteById(id);
    }
}