package pl.edu.ug.wknopp.kolokwium.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.edu.ug.wknopp.kolokwium.domain.PackOfCards;

import java.util.List;

public interface PackOfCardsRepository extends CrudRepository<PackOfCards, Long> {

    @Query("select p from PackOfCards p join fetch p.manufacturer")
    List<PackOfCards> getAllCardsWithManufacturers();

    @Query("select p from PackOfCards p join Theme t on p.theme = t where p.fullPack = true")
    List<PackOfCards> getAllFullPacksWithTheme();
}
