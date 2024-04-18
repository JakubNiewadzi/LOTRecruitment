package pl.niewadzj.LOTRecruitment.api.flight.interfaces;

import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;

import java.util.List;

public interface FlightController {

    List<FlightResponse> getFlights();
    void addFlight(FlightRequest flightRequest);
}
