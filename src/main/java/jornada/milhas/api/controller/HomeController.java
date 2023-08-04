package jornada.milhas.api.controller;

import jornada.milhas.api.domain.testimonial.GetTestimonialData;
import jornada.milhas.api.domain.testimonial.Testimonial;
import jornada.milhas.api.domain.testimonial.TestimonialRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("testimonial-home")
public class HomeController {

    private final TestimonialRepository repository;

    public HomeController(TestimonialRepository repository) {
        this.repository = repository;
    }

    public boolean testimonialActive(Long id){
        Testimonial testimonial = repository.getReferenceById(id);
        return testimonial.getActive();
    }

    @GetMapping
    public ResponseEntity<List<GetTestimonialData>> getRandoTestimonial(){
        List<Testimonial> testimonials =  repository.findAllByActiveTrue();

        if(testimonials.size() < 3){
            return ResponseEntity.noContent().build();
        }

        List<Integer> randomIndices = generateRandomIndices(testimonials.size());

        List<GetTestimonialData> randomTestimonials = new ArrayList<>();

        for (int index: randomIndices) {
            randomTestimonials.add(new GetTestimonialData(testimonials.get(index)));
        }

        return ResponseEntity.ok(randomTestimonials);

    }

    private List<Integer> generateRandomIndices(int max) {
        List<Integer> index = new ArrayList<>();
        Random random = new Random();

        while (index.size() < 3){
            int randomIndex = random.nextInt(max);
            if (!index.contains(randomIndex)){
                index.add(randomIndex);
            }
        }
        return index;
    }
}
