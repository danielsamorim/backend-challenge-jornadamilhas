package jornada.milhas.api.domain.destination;

public record GetDestinationData(

        Long id,
        String photo,
        String name,
        Double price
) {


    public GetDestinationData(Destination data) {
        this(data.getId(), data.getPhoto(), data.getName(), data.getPrice());
    }
}
