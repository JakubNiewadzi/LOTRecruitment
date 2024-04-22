package pl.niewadzj.LOTRecruitment.api.flight.records;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FlightResponse(
        @Schema(description = "Flight's unique identification number", example = "1")
        Long id,
        @Schema(description = "Flight's number", example = "LO1234")
        String flightNumber,
        @Schema(description = "Flight's date and hour", example = "2024-07-22T12:00:00.000Z")
        LocalDateTime flightDateTime,
        @Schema(description = "City where the flight starts", example = "Cracow")
        String startCity,
        @Schema(description = "Destination city of the flight", example = "Warsaw")
        String destinationCity,
        @Schema(description = "Current amount of free seats", example = "13")
        Integer freeSeats) {
}
