package jornada.milhas.api.domain.destination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Page<Destination> findAllByActiveTrue(Pageable pages);

    @Query("select d from Destination d where d.name = :name and d.active = true")
    List<Destination> findAllByName(String name);
}
