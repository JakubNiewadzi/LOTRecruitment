package pl.niewadzj.LOTRecruitment.api.flight.records;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FlightResponse(Long id,
                             String flightNumber,
                             LocalDateTime flightDateTime,
                             String startCity,
                             String destinationCity,
                             Integer freeSeats) {
}
