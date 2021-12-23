package org.baklykoff.rest.service;

import org.baklykoff.rest.repository.PaydeskRepository;
import org.baklykoff.rest.models.Paydesk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class PaydeskService {

    @Autowired
    private PaydeskRepository paydeskRepository;

    public Paydesk addPaydesk(final Paydesk paydesk) {
        return paydeskRepository.save(paydesk);
    }

    public Paydesk updatePaydesk(final Paydesk paydesk) {
        return paydeskRepository.save(paydesk);
    }

    public List<Paydesk> getPaydesks() {
        return paydeskRepository.findAll();
    }

    public Paydesk getPaydeskById(final Integer id) {
        return paydeskRepository.findById(id).orElse(null);
    }

    public void deletePaydeskById(final Integer id) {
        paydeskRepository.deleteById(id);
    }
}
