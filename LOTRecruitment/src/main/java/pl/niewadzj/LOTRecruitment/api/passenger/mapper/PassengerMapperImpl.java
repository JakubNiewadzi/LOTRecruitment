package pl.niewadzj.LOTRecruitment.api.passenger.mapper;

import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerMapper;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;
import pl.niewadzj.LOTRecruitment.entities.passenger.PhoneNumber;
import pl.niewadzj.LOTRecruitment.utils.StringUtils;

@Service
public class PassengerMapperImpl implements PassengerMapper {
    @Override
    public Passenger mapRequestToEntity(PassengerRequest passengerRequest) {
        final PhoneNumber phoneNumber = PhoneNumber.builder()
                .countryCode(passengerRequest.countryCode())
                .number(passengerRequest.number())
                .build();

        return Passenger.builder()
                .firstName(passengerRequest.firstName())
                .lastName(passengerRequest.lastName())
                .phoneNumber(phoneNumber)
                .build();
    }

    @Override
    public PassengerResponse mapEntityToResponse(Passenger passenger) {
        return PassengerResponse.builder()
                .id(passenger.getId())
                .name(String.format("%s %s",
                        StringUtils.capitalizeString(passenger.getFirstName()),
                        StringUtils.capitalizeString(passenger.getLastName())))
                .phoneNumber(String.format("%s %s",
                        passenger.getPhoneNumber().getCountryCode(),
                        passenger.getPhoneNumber().getNumber()))
                .build();
    }

}
