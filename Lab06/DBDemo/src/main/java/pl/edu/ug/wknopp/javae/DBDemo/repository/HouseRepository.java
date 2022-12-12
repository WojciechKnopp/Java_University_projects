package pl.edu.ug.wknopp.javae.DBDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.wknopp.javae.DBDemo.domain.House;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
    List<House> findByAreaOrNumberOfFloors(int area, int numberOfFloors);
}
