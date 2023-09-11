package jornada.milhas.api.domain.destination;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "destination")
@Entity(name = "Destination")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String name;
    private Double price;
    private Boolean active;

    public Destination(Long id, String photo, String name, Double price) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.price = price;
        this.active = true;
    }

    public void updateInformation(updateDestinationData data){
        if (data.photo() != null){
            this.photo = data.photo();
        }
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.price() != null){
            this.price = data.price();
        }
    }

    public void deleteDestination(){
        this.active = false;
    }
}
