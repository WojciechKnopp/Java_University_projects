package pl.edu.ug.wknopp.kolokwium.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.wknopp.kolokwium.domain.Manufacturer;
import pl.edu.ug.wknopp.kolokwium.domain.PackOfCards;
import pl.edu.ug.wknopp.kolokwium.domain.Theme;
import pl.edu.ug.wknopp.kolokwium.repository.PackOfCardsRepository;

import javax.transaction.Transactional;
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
            updatedPackOfCards.setFullPack(packOfCards.isFullPack());
            return packOfCardsRepository.save(updatedPackOfCards);
        }
        return null;
    }

    public boolean deletePackOfCards(Long id) {
        packOfCardsRepository.deleteById(id);
        Optional<PackOfCards> packOfCards = packOfCardsRepository.findById(id);
        return packOfCards.isEmpty();
    }

    public void presentation(){
        PackOfCards packOfCards = new PackOfCards();
        packOfCards.setTitle("Test");
        packOfCards.setFullPack(true);

        Theme theme = new Theme();
        theme.setName("Rośliny");
        packOfCards.setTheme(theme);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Producent");
        packOfCards.setManufacturer(manufacturer);

        packOfCardsRepository.save(packOfCards);

        System.out.println(packOfCardsRepository.getAllCardsWithManufacturers());
    }
}
