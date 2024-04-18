package pl.niewadzj.LOTRecruitment.api.flight.records;

import java.time.LocalDateTime;

public record FlightRequest(String flightNumber,
                            LocalDateTime localDateTime,
                            int amountOfSeats) {
}
