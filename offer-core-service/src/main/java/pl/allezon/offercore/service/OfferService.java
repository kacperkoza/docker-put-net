package pl.allezon.offercore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.allezon.offercore.domain.Offer;
import pl.allezon.offercore.persistence.OfferRepository;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final OfferDispatcher offerDispatcher;

    @Autowired
    public OfferService(OfferRepository offerRepository, OfferDispatcher offerDispatcher) {
        this.offerRepository = offerRepository;
        this.offerDispatcher = offerDispatcher;
    }

    public void createOffer(Offer offer) {
        offerRepository.save(offer);
        offerDispatcher.dispatch(offer);
    }
}
