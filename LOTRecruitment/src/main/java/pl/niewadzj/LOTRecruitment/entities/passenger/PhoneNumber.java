package pl.niewadzj.LOTRecruitment.entities.passenger;

import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

    private String countryCode;
    private String number;

}
