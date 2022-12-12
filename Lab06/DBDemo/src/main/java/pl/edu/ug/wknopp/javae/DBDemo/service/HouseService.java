package pl.edu.ug.wknopp.javae.DBDemo.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.wknopp.javae.DBDemo.domain.ConstructionCompany;
import pl.edu.ug.wknopp.javae.DBDemo.domain.House;
import pl.edu.ug.wknopp.javae.DBDemo.repository.HouseRepository;

import java.util.Optional;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void learning() {
        System.out.println("Learning");
        House h1 = new House(2, 100, 100000.0, 2000, "Nice house");
        House h2 = new House(3, 150, 150000.0, 2005, "House 2");
        House h3 = new House(4, 200, 200000.0, 2010);

        houseRepository.save(h1);
        houseRepository.save(h2);
        houseRepository.save(h3);

        Optional<House> foundHouse = houseRepository.findById(h1.getId());

        House h4 = new House(5, 250, 250000.0, 2015, "Z firmą budowlaną");
        ConstructionCompany c1 = new ConstructionCompany("Firma Budowlana 1");
        h4.setConstructionCompany(c1);
        houseRepository.save(h4);

        houseRepository.deleteById(h4.getId());

        System.out.println(houseRepository.findByAreaOrNumberOfFloors(100, 4));
    }
}
