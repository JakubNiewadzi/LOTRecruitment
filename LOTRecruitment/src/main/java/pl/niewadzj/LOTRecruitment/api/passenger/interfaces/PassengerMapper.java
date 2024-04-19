package pl.niewadzj.LOTRecruitment.api.passenger.interfaces;

import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;

public interface PassengerMapper {

    Passenger mapRequestToEntity(PassengerRequest passengerRequest);
    PassengerResponse mapEntityToResponse(Passenger passenger);

}
