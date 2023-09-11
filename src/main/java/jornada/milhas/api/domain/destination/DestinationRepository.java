package jornada.milhas.api.domain.destination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Page<Destination> findAllByActiveTrue(Pageable pages);
}
