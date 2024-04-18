package pl.niewadzj.LOTRecruitment.api.flight.interfaces;

import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;

import java.util.List;

public interface FlightService {
    List<FlightResponse> getFlights();

    FlightResponse addFlight(FlightRequest flightRequest);

    FlightResponse updateFlight(FlightRequest flightRequest, Long id);

    FlightResponse deleteFlight(Long id);

    FlightResponse reserveSeat(Long flightId, Long passengerId);

    FlightResponse freeOccupiedSeat(Long flightId, Long passengerId);
}
