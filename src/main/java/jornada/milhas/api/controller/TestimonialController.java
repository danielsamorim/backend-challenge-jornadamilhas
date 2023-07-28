package jornada.milhas.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jornada.milhas.api.domain.testimonial.PostTestimonialData;
import jornada.milhas.api.domain.testimonial.Testimonial;
import jornada.milhas.api.domain.testimonial.TestimonialRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("testimonial")
public class TestimonialController {


    private final TestimonialRepository repository;

    public TestimonialController(TestimonialRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void post(@RequestBody PostTestimonialData data){

        repository.save(new Testimonial(data));

    }


}
