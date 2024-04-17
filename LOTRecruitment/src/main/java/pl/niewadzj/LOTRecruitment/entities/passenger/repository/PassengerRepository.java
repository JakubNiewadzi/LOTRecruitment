package pl.niewadzj.LOTRecruitment.entities.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
