package pl.edu.ug.wknopp.javae.DBDemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.wknopp.javae.DBDemo.domain.House;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
    List<House> findByAreaOrNumberOfFloors(int area, int numberOfFloors);
    List<House> findByAreaAndNumberOfFloors(int area, int numberOfFloors);
    List<House> findByPriceLessThanEqual(double price);
    List<House> findByDescriptionNotNull();
    @Query("SELECT h FROM House h WHERE h.yearOfConstruction > ?1")
    List<House> findYoungerThan(int year);
    @Query("SELECT h FROM House h WHERE size(h.owners) < ?1")
    List<House> findWhereOwnersQuantityLessThan(int quantity);
    @Query("SELECT h FROM House h join fetch h.owners WHERE h.price < ?1")
    List<House> findWithOwnersCheaperThan(double price);
    @Query(nativeQuery = true,value = "SELECT * FROM House")
    List<House> findAllHouses();

    //n+1 queries
    @Query("SELECT h FROM House h join fetch h.address")
    List<House> getAllHousesWithAddress();
}
