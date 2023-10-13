package jornada.milhas.api.domain.destination;

import jakarta.validation.constraints.NotNull;

public record updateDestinationData(

        @NotNull
        Long id,
        String firstPhoto,
        String secondPhoto,
        String meta,
        String name,
        Double price,
        String description
        ) {
}
