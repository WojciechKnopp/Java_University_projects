package pl.edu.ug.wknopp.javae.DBDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.javae.DBDemo.domain.House;
import pl.edu.ug.wknopp.javae.DBDemo.service.HouseService;

import java.util.List;

@RestController
public class HouseController{

    private final HouseService houseService;

    public HouseController(@Autowired HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/api/house/{id}")
    House getHouse(@PathVariable("id") Long id) {
        return houseService.getHouse(id);
    }

    @GetMapping("/api/house")
    List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping("/api/house")
    ResponseEntity<House> addHouse(@RequestBody House house) {
        House createdHouse = houseService.addHouse(house);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/house/" + createdHouse.getId());
        return new ResponseEntity<>(createdHouse, headers, HttpStatus.CREATED);
    }

    @PutMapping("/api/house/{id}")
    House updateHouse(@PathVariable("id") Long id, @RequestBody House house) {
        return houseService.updateHouse(id, house);
    }

    @DeleteMapping("/api/house/{id}")
    boolean deleteHouse(@PathVariable("id") Long id) {
        return houseService.deleteHouse(id);
    }

}
