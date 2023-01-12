package pl.edu.ug.wknopp.javae.DBDemo.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.wknopp.javae.DBDemo.domain.Address;
import pl.edu.ug.wknopp.javae.DBDemo.domain.ConstructionCompany;
import pl.edu.ug.wknopp.javae.DBDemo.domain.House;
import pl.edu.ug.wknopp.javae.DBDemo.domain.Person;
import pl.edu.ug.wknopp.javae.DBDemo.repository.HouseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House getHouse(Long id) {
        Optional<House> h1 = houseRepository.findById(id);
        return h1.orElse(null);
    }

    public List<House> getAllHouses() {
        return houseRepository.findAllHouses();
    }

    public House addHouse(House house) {
        House createdHouse = new House(
                house.getNumberOfFloors(),
                house.getArea(),
                house.getPrice(),
                house.getYearOfConstruction(),
                house.getConstructionCompany(),
                house.getOwners(),
                house.getDescription()
        );
        return houseRepository.save(createdHouse);
    }

    public House updateHouse(Long id, House house){
        Optional<House> updatedHouse = houseRepository.findById(id);
        if(updatedHouse.isEmpty()){
            return null;
        }
        if(house.getNumberOfFloors() != null) updatedHouse.get().setNumberOfFloors(house.getNumberOfFloors());
        if(house.getArea() != null) updatedHouse.get().setArea(house.getArea());
        if(house.getAddress() != null) updatedHouse.get().setAddress(house.getAddress());
        if(house.getPrice() != null) updatedHouse.get().setPrice(house.getPrice());
        if(house.getYearOfConstruction() != null) updatedHouse.get().setYearOfConstruction(house.getYearOfConstruction());
        if(house.getDescription() != null) updatedHouse.get().setDescription(house.getDescription());
        if(house.getConstructionCompany() != null) updatedHouse.get().setConstructionCompany(house.getConstructionCompany());
        if(house.getOwners() != null) updatedHouse.get().setOwners(house.getOwners());
        return updatedHouse.get();
    }

    public boolean deleteHouse(Long id){
        houseRepository.deleteById(id);
        Optional<House> deletedHouse = houseRepository.findById(id);
        return deletedHouse.isEmpty();
    }



    public void learning() {
        System.out.println("Learning");
        House h1 = new House(2, 100, 100000.0, 2000, "Nice house");
        House h2 = new House(3, 150, 150000.0, 2005, "House 2");
        House h3 = new House(4, 200, 200000.0, 2010);

        Person p1 = new Person("Jan", "Kowalski", "Jan@gmail.com", "123456789");
        Person p2 = new Person("Adam", "Nowak", "Adam@gmail.com", "987654321");
        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        h1.setOwners(persons);

        House savedHouse1 = houseRepository.save(h1);
        houseRepository.save(h2);
        houseRepository.save(h3);

        h1.setAddress(new Address("Kosmonautow", "Wroclaw", "12", "Poland"));
        h2.setAddress(new Address("Andrzejow", "Krakow", "1", "Poland"));
        h3.setAddress(new Address("Nowa", "Hel", "12", "Poland"));

        Optional<House> foundHouse = houseRepository.findById(h1.getId());

        House h4 = new House(5, 250, 250000.0, 2015, "Z firmą budowlaną");
        ConstructionCompany c1 = new ConstructionCompany("Firma Budowlana 1");
        h4.setConstructionCompany(c1);
        House houseWithCompany = houseRepository.save(h4);


        houseRepository.deleteById(h4.getId());

        System.out.println(houseRepository.findByAreaOrNumberOfFloors(100, 4));


        System.out.println(houseRepository.findWithOwnersCheaperThan(150000));

        System.out.println(houseRepository.findByAreaAndNumberOfFloors(200, 4));

    }

    public void lab10(){
        System.out.println("Lab10");
//        n+1 queries
//        for(House h : houseRepository.findAllHouses()){
//            System.out.println(h.getAddress());
//        }
        for(House h : houseRepository.getAllHousesWithAddress()){
            System.out.println(h.getAddress());
        }

        //Optional usages
        houseRepository.findById(1L).ifPresent(System.out::println);
        houseRepository.findById(8L).ifPresentOrElse(System.out::println, () -> System.out.println("Nie znaleziono"));
        House h1 = houseRepository.findById(1L).orElse(null);
//        House h2 = houseRepository.findById(8L).orElseThrow(RuntimeException::new);
        Optional<House> optHouse = houseRepository.findById(1L);
        Address a1 = optHouse.map(House::getAddress).orElse(null);
    }
}
