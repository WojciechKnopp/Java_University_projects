package pl.edu.ug.wknopp.javae.houseWebApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such House in database")
public class HouseNotFoundException extends RuntimeException {
}
