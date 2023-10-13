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
    @Column(name = "first_photo")
    private String firstPhoto;
    @Column(name = "second_photo")
    private String secondPhoto;
    private String name;
    private String meta;
    private Double price;
    private String description;
    private Boolean active;

    public Destination(PostDestination data) {
        this.firstPhoto = data.firstPhoto();
        this.secondPhoto = data.secondPhoto();
        this.name = data.name();
        this.price = data.price();
        this.description = data.description();
        this.active = true;
    }


    public void updateInformation(updateDestinationData data){
        if (data.firstPhoto() != null){
            this.firstPhoto = data.firstPhoto();
        }
        if (data.secondPhoto() != null){
            this.secondPhoto = data.secondPhoto();
        }
        if (data.meta() != null){
            this.meta = data.meta();
        }
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.price() != null){
            this.price = data.price();
        }
        if (data.description() != null){
            this.description = data.description();
        }
    }

    public void delete(){
        this.active = false;
    }
}
