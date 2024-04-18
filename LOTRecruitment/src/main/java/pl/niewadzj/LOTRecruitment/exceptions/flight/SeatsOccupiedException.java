package pl.niewadzj.LOTRecruitment.exceptions.flight;

import pl.niewadzj.LOTRecruitment.exceptions.BadRequestException;

public class SeatsOccupiedException extends BadRequestException {
    public SeatsOccupiedException() {
        super("All seats are already occupied");
    }
}
