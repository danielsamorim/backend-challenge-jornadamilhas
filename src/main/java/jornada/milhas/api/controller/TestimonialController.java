package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.testimonial.PostTestimonialData;
import jornada.milhas.api.domain.testimonial.Testimonial;
import jornada.milhas.api.domain.testimonial.TestimonialRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("testimonial")
public class TestimonialController {


    private final TestimonialRepository repository;

    public TestimonialController(TestimonialRepository repository) {
        this.repository = repository;
    }



    @PostMapping
    @Transactional
    public ResponseEntity addTestimonial(@RequestBody @Valid PostTestimonialData data){

        repository.save(new Testimonial(data));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


}
