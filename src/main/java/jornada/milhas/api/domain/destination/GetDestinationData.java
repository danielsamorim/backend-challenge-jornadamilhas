package jornada.milhas.api.domain.destination;

public record GetDestinationData(

        Long id,
        String firstPhoto,
        String name,
        Double price
) {


    public GetDestinationData(Destination data) {
        this(data.getId(), data.getFirstPhoto(), data.getName(), data.getPrice());
    }
}
