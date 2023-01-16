package pl.edu.ug.wknopp.kolokwium.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.wknopp.kolokwium.domain.PackOfCards;
import pl.edu.ug.wknopp.kolokwium.repository.PackOfCardsRepository;

import java.util.Optional;

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

    public PackOfCards updatePackOfCards(Long id, PackOfCards packOfCards) {
        PackOfCards updatedPackOfCards = packOfCardsRepository.findById(id).orElse(null);
        if (updatedPackOfCards != null) {
            updatedPackOfCards.setTitle(packOfCards.getTitle());
            updatedPackOfCards.setFullPack(packOfCards.getFullPack());
            return packOfCardsRepository.save(updatedPackOfCards);
        }
        return null;
    }

    public boolean deletePackOfCards(Long id) {
        packOfCardsRepository.deleteById(id);
        Optional<PackOfCards> packOfCards = packOfCardsRepository.findById(id);
        return packOfCards.isEmpty();
    }
}
