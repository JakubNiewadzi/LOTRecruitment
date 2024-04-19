package pl.niewadzj.LOTRecruitment.api.passenger.records;

public record PassengerRequest(String firstName,
                               String lastName,
                               String countryCode,
                               String number) {
}
