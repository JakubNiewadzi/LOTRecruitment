package pl.niewadzj.LOTRecruitment.entities.passenger;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Embeddable
public class PhoneNumber {

    private String countryCode;
    private String number;

}
