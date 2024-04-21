package pl.niewadzj.LOTRecruitment.api.flight.records;

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
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_CITY_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_FLIGHT_DATE_TIME_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.ValidationConstants.NULL_FLIGHT_NUMBER_MESSAGE;

public record FlightRequest(@NotNull(message = NULL_FLIGHT_NUMBER_MESSAGE)
                            @Pattern(regexp = FLIGHT_NUMBER_REGEX, message = INVALID_FLIGHT_NUMBER_MESSAGE)
                            String flightNumber,
                            @NotNull(message = NULL_FLIGHT_DATE_TIME_MESSAGE)
                            @AfterDay
                            LocalDateTime flightDateTime,
                            @NotNull(message = NULL_CITY_MESSAGE)
                            @Pattern(regexp = CITY_REGEX, message = INVALID_CITY_MESSAGE)
                            String startCity,
                            @NotNull(message = NULL_CITY_MESSAGE)
                            @Pattern(regexp = CITY_REGEX, message = INVALID_CITY_MESSAGE)
                            String destinationCity,

                            @NotNull
                            @Min(value = MIN_AMOUNT_OF_SEATS, message = MIN_AMOUNT_OF_SEATS_MESSAGE)
                            @Max(value = MAX_AMOUNT_OF_SEATS, message = MAX_AMOUNT_OF_SEATS_MESSAGE)
                            Integer amountOfSeats) {
}
