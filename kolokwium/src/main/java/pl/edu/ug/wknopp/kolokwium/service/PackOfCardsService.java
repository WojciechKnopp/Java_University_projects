package pl.edu.ug.wknopp.kolokwium.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.wknopp.kolokwium.domain.PackOfCards;
import pl.edu.ug.wknopp.kolokwium.repository.PackOfCardsRepository;

import java.util.List;

@Service
public class PackOfCardsService {

    private final PackOfCardsRepository packOfCardsRepository;

    public PackOfCardsService(PackOfCardsRepository packOfCardsRepository) {
        this.packOfCardsRepository = packOfCardsRepository;
    }

    public Iterable<PackOfCards> getAllPacksOfCards() {
        return packOfCardsRepository.findAll();
    }

    public PackOfCards getPackOfCards(Long id) {
        return packOfCardsRepository.findById(id).orElse(null);
    }

    public PackOfCards addPackOfCards(PackOfCards packOfCards) {
        return packOfCardsRepository.save(packOfCards);
    }
}
