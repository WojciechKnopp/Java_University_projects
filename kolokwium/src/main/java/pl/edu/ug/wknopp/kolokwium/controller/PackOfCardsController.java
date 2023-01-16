package pl.edu.ug.wknopp.kolokwium.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.wknopp.kolokwium.domain.PackOfCards;
import pl.edu.ug.wknopp.kolokwium.service.PackOfCardsService;

@RestController
public class PackOfCardsController {

    private final PackOfCardsService packOfCardsService;

    public PackOfCardsController(PackOfCardsService packOfCardsService) {
        this.packOfCardsService = packOfCardsService;
    }

    @GetMapping("/api/pack")
    Iterable<PackOfCards> getAllPackOfCards() {
        return packOfCardsService.getAllPacksOfCards();
    }

    @GetMapping("/api/pack/{id}")
    PackOfCards getPackOfCards(@PathVariable("id")Long id) {
        return packOfCardsService.getPackOfCards(id);
    }

    @PostMapping("/api/pack")
    ResponseEntity<PackOfCards> addPackOfCards(@RequestBody PackOfCards packOfCards) {
        PackOfCards createdPackOfCards = packOfCardsService.addPackOfCards(packOfCards);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/pack/" + createdPackOfCards.getId());
        return new ResponseEntity<>(createdPackOfCards, headers, HttpStatus.CREATED);
    }

    @PutMapping("/api/pack/{id}")
    PackOfCards updatePackOfCards(@PathVariable("id") Long id, @RequestBody PackOfCards packOfCards) {
        return packOfCardsService.updatePackOfCards(id, packOfCards);
    }

    @DeleteMapping("/api/pack/{id}")
    boolean deletePackOfCards(@PathVariable("id") Long id) {
        return packOfCardsService.deletePackOfCards(id);
    }
}
