package pl.niewadzj.LOTRecruitment.api.flight.records;

import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record FlightRequest(@Pattern(regexp = "^LO\\d{2,4}$")
                            String flightNumber,
                            LocalDateTime localDateTime,
                            int amountOfSeats) {
}
