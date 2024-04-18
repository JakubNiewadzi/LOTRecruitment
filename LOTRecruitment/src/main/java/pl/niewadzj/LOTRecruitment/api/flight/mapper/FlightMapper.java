package pl.niewadzj.LOTRecruitment.api.flight.mapper;

import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;

import java.util.function.Function;

@Service
public class FlightMapper implements Function<Flight, FlightResponse> {
    @Override
    public final FlightResponse apply(Flight flight) {
        return FlightResponse.builder()
                .id(flight.getId())
                .flightDateTime(flight.getFlightDateTime())
                .flightNumber(flight.getFlightNumber())
                .freeSeats(flight.getFreeSeats())
                .build();
    }
}
