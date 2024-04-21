package pl.niewadzj.LOTRecruitment.exceptions.flight;

import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;

public class FlightAlreadyStartedException extends BadRequestException {
    public FlightAlreadyStartedException() {
        super("You cannot change seats in this flight, cause it already started");
    }
}
