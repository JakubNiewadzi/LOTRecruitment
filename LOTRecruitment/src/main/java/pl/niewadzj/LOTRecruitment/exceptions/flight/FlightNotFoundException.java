package pl.niewadzj.LOTRecruitment.exceptions.flight;

import pl.niewadzj.LOTRecruitment.exceptions.NotFoundException;

public class FlightNotFoundException extends NotFoundException {
    public FlightNotFoundException(Long id) {
        super(String.format("Flight with id %d has not been found", id));
    }
}
