package pl.niewadzj.LOTRecruitment.api.flight.records;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FlightFilter(
        LocalDateTime minFlightDateTime,
        LocalDateTime maxFlightDateTime,
        String startCity,
        String destinationCity,
        String flightNumber,
        Integer minFreeSeats,
        Integer maxFreeSeats) {
}
