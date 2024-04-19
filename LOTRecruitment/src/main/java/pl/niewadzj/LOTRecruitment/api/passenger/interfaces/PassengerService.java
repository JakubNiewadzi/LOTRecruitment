package pl.niewadzj.LOTRecruitment.api.passenger.interfaces;

import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;

import java.util.List;

public interface PassengerService {
    List<PassengerResponse> getAll();

    PassengerResponse addPassenger(PassengerRequest passengerRequest);

    PassengerResponse deletePassenger(Long id);

    PassengerResponse updatePassenger(PassengerRequest passengerRequest, Long id);
}
