package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.destination.*;
import jornada.milhas.api.domain.testimonial.updateTestimonialData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationRepository repository;

    public DestinationController(DestinationRepository repository) {
        this.repository = repository;
    }

    public boolean destinantionActive(Long id){
        Destination destination = repository.getReferenceById(id);
        return destination.getActive();
    }

    @PostMapping
    @Transactional
    public ResponseEntity addDestination(@RequestBody @Valid PostDestination data){
        repository.save(new Destination(data));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<GetDestinationData> getDestination(@PageableDefault(size = 5, sort = {"id"}) Pageable pages){
        var destination = repository.findAllByActiveTrue(pages).map(GetDestinationData::new);
        return ResponseEntity.ok(destination).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity getDestinationById(@PathVariable Long id){
        var destinantion = repository.getReferenceById(id);

        if (destinantionActive(destinantion.getId())){
            return ResponseEntity.ok(new GetDestinationData(destinantion));
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateDestination(@RequestBody @Valid updateDestinationData data){
        var destination = repository.getReferenceById(data.id());
        destination.updateInformation(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDestination(@PathVariable Long id){
        var destination = repository.getReferenceById(id);
        destination.delete();
        return ResponseEntity.noContent().build();
    }
}
