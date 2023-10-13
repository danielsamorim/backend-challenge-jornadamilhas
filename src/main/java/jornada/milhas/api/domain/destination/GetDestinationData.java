package jornada.milhas.api.domain.destination;

public record GetDestinationData(

        Long id,
        String firstPhoto,
        String secondPhoto,
        String meta,
        String name,
        Double price,
        String description
) {


    public GetDestinationData(Destination data) {
        this(data.getId(), data.getFirstPhoto(), data.getSecondPhoto(), data.getMeta(), data.getName(), data.getPrice(), data.getDescription());
    }
}
