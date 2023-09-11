package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.destination.Destination;
import jornada.milhas.api.domain.destination.DestinationRepository;
import jornada.milhas.api.domain.destination.PostDestination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationRepository repository;

    public DestinationController(DestinationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity addDestination(@RequestBody @Valid PostDestination data){
        repository.save(new Destination(data));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
