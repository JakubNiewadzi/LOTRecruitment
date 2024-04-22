package pl.niewadzj.LOTRecruitment.api.passenger.records;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record PassengerResponse(
        @Schema(description = "Passenger's unique identification number", example = "1")
        Long id,
        @Schema(description = "Passenger's full name", example = "Jakub Niewadzi")
        String name,
        @Schema(description = "Passenger's full phone number", example = "+48 515 183 826")
        String phoneNumber) {
}
