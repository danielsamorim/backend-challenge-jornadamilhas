package jornada.milhas.api.controller;

import jornada.milhas.api.domain.testimonial.PostTestimonial;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("testimonial")
public class TestimonialController {



    @PostMapping
    public void post(@RequestBody PostTestimonial dtotestimonial){

        System.out.println(dtotestimonial);
    }


}
