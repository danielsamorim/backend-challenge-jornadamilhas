package jornada.milhas.api.domain.destination;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostDestination(
        @NotNull
        String firstPhoto,
        @NotNull
        String secondPhoto,
        @NotNull
        @Size(max = 160)
        String meta,
        @NotNull
        String name,
        @NotNull
        Double price,
        String description
) {
}
