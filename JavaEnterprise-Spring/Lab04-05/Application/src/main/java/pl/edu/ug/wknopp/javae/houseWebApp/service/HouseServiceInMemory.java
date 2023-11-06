package pl.edu.ug.wknopp.javae.houseWebApp.service;

import org.springframework.stereotype.Component;
import pl.edu.ug.wknopp.javae.houseWebApp.domain.House;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class HouseServiceInMemory implements HouseService{

    List<House> db = new ArrayList<>();

    @Override
    public House getHouse(String id) {
        for (House house : db) {
            if (house.getId().equals(id)) {
                return house;
            }
        }
        return null;
    }

    @Override
    public List<House> getAllHouses() {
        return db;
    }

    @Override
    public House addHouse(House house) {
        House createdHouse = new House(
                UUID.randomUUID().toString(),
                house.getNumberOfFloors(),
                house.getArea(),
                house.getAddress(),
                house.getPrice(),
                house.getYearOfConstruction(),
                house.getDescription()
        );
        db.add(createdHouse);
        return createdHouse;
    }

    @Override
    public House updateHouse(String id, House house){
        House updatedHouse = getHouse(id);
        if(updatedHouse == null){
            return null;
        }
        if(house.getNumberOfFloors() != null) updatedHouse.setNumberOfFloors(house.getNumberOfFloors());
        if(house.getArea() != null) updatedHouse.setArea(house.getArea());
        if(house.getAddress() != null) updatedHouse.setAddress(house.getAddress());
        if(house.getPrice() != null) updatedHouse.setPrice(house.getPrice());
        if(house.getYearOfConstruction() != null) updatedHouse.setYearOfConstruction(house.getYearOfConstruction());
        if(house.getDescription() != null) updatedHouse.setDescription(house.getDescription());
        return updatedHouse;
    }

    @Override
    public boolean deleteHouse(String id){
        House houseToDelete = getHouse(id);
        if(houseToDelete == null){
            return false;
        }
        return db.remove(houseToDelete);
    }
}
