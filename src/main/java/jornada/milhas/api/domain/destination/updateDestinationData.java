package jornada.milhas.api.domain.destination;

import jakarta.validation.constraints.NotNull;

public record updateDestinationData(

        @NotNull
        Long id,
        String firstPhoto,
        String name,
        Double price) {
}
