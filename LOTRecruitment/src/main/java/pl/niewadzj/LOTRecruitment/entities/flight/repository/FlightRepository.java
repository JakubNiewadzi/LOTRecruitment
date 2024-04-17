package pl.niewadzj.LOTRecruitment.entities.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightRepository, Long> {
}
