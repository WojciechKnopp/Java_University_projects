package pl.edu.ug.wknopp.javae.DBDemo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found House with given id")
public class HouseNotFoundException extends RuntimeException{
}
