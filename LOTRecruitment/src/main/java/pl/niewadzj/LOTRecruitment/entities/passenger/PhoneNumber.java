package pl.niewadzj.LOTRecruitment.entities.passenger;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    private String countryCode;
    private String number;

}
