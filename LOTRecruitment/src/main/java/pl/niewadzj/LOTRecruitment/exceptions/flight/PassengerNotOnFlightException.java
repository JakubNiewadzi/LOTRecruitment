package pl.niewadzj.LOTRecruitment.exceptions.flight;

import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;

public class PassengerNotOnFlightException extends BadRequestException {
    public PassengerNotOnFlightException() {
        super("This passenger has not occupied a seat on this flight");
    }
}
