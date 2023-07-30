package jornada.milhas.api.domain.testimonial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

    Page<Testimonial> findAllByActiveTrue(Pageable page);

}
