package pl.niewadzj.LOTRecruitment.api.passenger.records;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.COUNTRY_CODE_REGEX;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.INVALID_COUNTRY_CODE_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.INVALID_NAME_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.INVALID_NUMBER_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.NAME_REGEX;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.NULL_COUNTRY_CODE_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.NULL_NAME_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.NULL_NUMBER_MESSAGE;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.ValidationConstants.NUMBER_REGEX;

public record PassengerRequest(@NotNull(message = NULL_NAME_MESSAGE)
                               @Pattern(regexp = NAME_REGEX, message = INVALID_NAME_MESSAGE)
                               @Schema(description = "Passenger's first name", defaultValue = "Jakub")
                               String firstName,
                               @NotNull(message = NULL_NAME_MESSAGE)
                               @Pattern(regexp = NAME_REGEX, message = INVALID_NAME_MESSAGE)
                               @Schema(description = "Passenger's last name", defaultValue = "Niewadzi")
                               String lastName,
                               @NotNull(message = NULL_COUNTRY_CODE_MESSAGE)
                               @Pattern(regexp = COUNTRY_CODE_REGEX, message = INVALID_COUNTRY_CODE_MESSAGE)
                               @Schema(description = "Passenger's phone number country code", defaultValue = "+48")
                               String countryCode,
                               @NotNull(message = NULL_NUMBER_MESSAGE)
                               @Pattern(regexp = NUMBER_REGEX, message = INVALID_NUMBER_MESSAGE)
                               @Schema(description = "Passenger's phone number", defaultValue = "515 183 826")
                               String number) {
}
