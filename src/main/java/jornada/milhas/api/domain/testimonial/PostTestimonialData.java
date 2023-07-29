package jornada.milhas.api.domain.testimonial;

import jakarta.validation.constraints.NotNull;

public record PostTestimonialData(

        @NotNull
        String name,
        @NotNull
        String text,
        @NotNull
        String photo
) {
}
