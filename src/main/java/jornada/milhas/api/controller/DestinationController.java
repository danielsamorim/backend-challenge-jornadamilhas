package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.destination.Destination;
import jornada.milhas.api.domain.destination.DestinationRepository;
import jornada.milhas.api.domain.destination.GetDestinationData;
import jornada.milhas.api.domain.destination.PostDestination;
import jornada.milhas.api.domain.testimonial.GetTestimonialData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<GetDestinationData> getDestination(@PageableDefault(size = 5, sort = {"id"}) Pageable pages){

    }



}
