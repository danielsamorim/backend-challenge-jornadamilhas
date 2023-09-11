package jornada.milhas.api.domain.destination;

import jakarta.validation.constraints.NotNull;

public record PostDestination(
        @NotNull
        String photo,
        @NotNull
        String name,
        @NotNull
        Double price
) {
}
