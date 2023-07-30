package jornada.milhas.api.domain.testimonial;

import jornada.milhas.api.domain.testimonial.Testimonial;

public record GetTestimonialData(
        Long id,
        String name,
        String text,
        String photo

) {

    public GetTestimonialData(Testimonial data){
        this(data.getId(), data.getName(), data.getText(), data.getPhoto());

    }
}
