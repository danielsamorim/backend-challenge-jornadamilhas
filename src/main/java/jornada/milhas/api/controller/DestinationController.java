package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.destination.PostDestination;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @PostMapping
    public ResponseEntity addDestination(@RequestBody @Valid PostDestination data){

    }


}
