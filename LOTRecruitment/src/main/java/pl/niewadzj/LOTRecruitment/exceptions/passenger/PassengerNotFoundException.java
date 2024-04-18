package pl.niewadzj.LOTRecruitment.exceptions.passenger;

import pl.niewadzj.LOTRecruitment.exceptions.NotFoundException;

public class PassengerNotFoundException extends NotFoundException {
    public PassengerNotFoundException(Long id) {
        super(String.format("Passneger with id %d has not been found", id));
    }
}
