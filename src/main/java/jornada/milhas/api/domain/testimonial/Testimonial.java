package jornada.milhas.api.domain.testimonial;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "testimonial")
@Entity(name = "Testimonial")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Testimonial {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String testimonial;
    private String photoPath;
    private boolean active;

    public Testimonial(PostTestimonialData data) {
        this.name = data.name();
        this.testimonial = data.testimonial();
        this.photoPath = data.photoPath();
        this.active = true;
    }
}
