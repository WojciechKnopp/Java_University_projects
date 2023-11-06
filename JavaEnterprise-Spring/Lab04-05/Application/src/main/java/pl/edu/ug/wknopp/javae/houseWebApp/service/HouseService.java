package pl.edu.ug.wknopp.javae.houseWebApp.service;

import pl.edu.ug.wknopp.javae.houseWebApp.domain.House;

import java.util.List;

public interface HouseService {
    House getHouse(String id);

    List<House> getAllHouses();

    House addHouse(House house);

    House updateHouse(String id, House house);

    boolean deleteHouse(String id);
}
