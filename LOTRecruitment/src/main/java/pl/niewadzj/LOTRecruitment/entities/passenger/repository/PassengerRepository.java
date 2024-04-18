package pl.niewadzj.LOTRecruitment.entities.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
