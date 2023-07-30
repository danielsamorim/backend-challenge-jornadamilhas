package jornada.milhas.api.controller;

import jakarta.validation.Valid;
import jornada.milhas.api.domain.testimonial.GetTestimonialData;
import jornada.milhas.api.domain.testimonial.PostTestimonialData;
import jornada.milhas.api.domain.testimonial.Testimonial;
import jornada.milhas.api.domain.testimonial.TestimonialRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("testimonial")
public class TestimonialController {


    private final TestimonialRepository repository;

    public TestimonialController(TestimonialRepository repository) {
        this.repository = repository;
    }

    public boolean testimonialActive(Long id){
        Testimonial testimonial = repository.getReferenceById(id);
        return testimonial.getActive();
    }



    @PostMapping
    @Transactional
    public ResponseEntity addTestimonial(@RequestBody @Valid PostTestimonialData data){

        repository.save(new Testimonial(data));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    @GetMapping
    public Page<GetTestimonialData> getTestimonial(@PageableDefault(size = 5, sort = {"id"}) Pageable pages){

        return repository.findAllByActiveTrue(pages).map(GetTestimonialData::new);

    }


    @GetMapping("/{id}")
    public ResponseEntity getTestimonialById(@PathVariable Long id){

        var testimonial = repository.getReferenceById(id);

        if(testimonialActive(testimonial.getId())){

            return ResponseEntity.ok(new GetTestimonialData(testimonial));

        }

        return ResponseEntity.noContent().build();
    }





}
