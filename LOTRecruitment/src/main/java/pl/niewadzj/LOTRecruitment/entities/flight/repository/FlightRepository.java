package pl.niewadzj.LOTRecruitment.entities.flight.repository;

import jakarta.annotation.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {

    List<Flight> findAll(@Nullable Specification<Flight> specification);

}
