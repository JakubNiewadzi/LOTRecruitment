package pl.niewadzj.LOTRecruitment.exceptions.flight;

import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;

public class SeatAlreadyReservedException extends BadRequestException {
    public SeatAlreadyReservedException() {
        super("This passenger has already reserved a seat on this flight");
    }
}
