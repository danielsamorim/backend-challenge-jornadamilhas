package jornada.milhas.api.domain.testimonial;

import jakarta.validation.constraints.NotNull;

public record updateTestimonialData(
        @NotNull
        Long id,
        String name,
        String text,
        String photo

) {
}
