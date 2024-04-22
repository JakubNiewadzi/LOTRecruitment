package pl.niewadzj.LOTRecruitment.api.flight.records;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pl.niewadzj.LOTRecruitment.validation.annotations.AfterDay;

import java.time.LocalDateTime;

import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.CITY_REGEX;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.FLIGHT_NUMBER_REGEX;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.INVALID_CITY_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.INVALID_FLIGHT_NUMBER_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.MAX_AMOUNT_OF_SEATS;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.MAX_AMOUNT_OF_SEATS_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.MIN_AMOUNT_OF_SEATS;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.MIN_AMOUNT_OF_SEATS_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_AMOUNT_OF_SEATS_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_CITY_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_FLIGHT_DATE_TIME_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_FLIGHT_NUMBER_MESSAGE;

public record FlightRequest(@NotNull(message = NULL_FLIGHT_NUMBER_MESSAGE)
                            @Pattern(regexp = FLIGHT_NUMBER_REGEX, message = INVALID_FLIGHT_NUMBER_MESSAGE)
                            @Schema(description = "Flight number", example = "LO1234")
                            String flightNumber,
                            @NotNull(message = NULL_FLIGHT_DATE_TIME_MESSAGE)
                            @AfterDay
                            @Schema(description = "Flight's date and hour", example = "2024-07-22T12:00:00.000Z")
                            LocalDateTime flightDateTime,
                            @NotNull(message = NULL_CITY_MESSAGE)
                            @Pattern(regexp = CITY_REGEX, message = INVALID_CITY_MESSAGE)
                            @Schema(description = "City where the flight starts", example = "Cracow")
                            String startCity,
                            @NotNull(message = NULL_CITY_MESSAGE)
                            @Pattern(regexp = CITY_REGEX, message = INVALID_CITY_MESSAGE)
                            @Schema(description = "Destination city of the flight", example = "Warsaw")
                            String destinationCity,

                            @NotNull(message = NULL_AMOUNT_OF_SEATS_MESSAGE)
                            @Min(value = MIN_AMOUNT_OF_SEATS, message = MIN_AMOUNT_OF_SEATS_MESSAGE)
                            @Max(value = MAX_AMOUNT_OF_SEATS, message = MAX_AMOUNT_OF_SEATS_MESSAGE)
                            @Schema(description = "Initial amount of free seats", example = "20")
                            Integer amountOfSeats) {
}
