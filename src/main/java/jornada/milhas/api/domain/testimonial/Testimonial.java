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



}
