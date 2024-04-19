package pl.niewadzj.LOTRecruitment.api.flight.interfaces;

import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;

public interface FlightMapper {

    FlightResponse mapEntityToResponse(Flight flight);
    Flight mapRequestToEntity(FlightRequest flightRequest);

}
