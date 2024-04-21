package pl.niewadzj.LOTRecruitment.api.flight.mapper;

import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightMapper;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;
import pl.niewadzj.LOTRecruitment.utils.StringUtils;

@Service
public class FlightMapperImpl implements FlightMapper {
    public final FlightResponse mapEntityToResponse(Flight flight) {
        return FlightResponse.builder()
                .id(flight.getId())
                .flightDateTime(flight.getFlightDateTime())
                .flightNumber(flight.getFlightNumber())
                .freeSeats(flight.getFreeSeats())
                .startCity(flight.getStartCity())
                .destinationCity(flight.getDestinationCity())
                .build();
    }

    public final Flight mapRequestToEntity(FlightRequest flightRequest) {
        return Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .flightDateTime(flightRequest.flightDateTime())
                .freeSeats(flightRequest.amountOfSeats())
                .startCity(StringUtils.capitalizeString(flightRequest.startCity()))
                .destinationCity(StringUtils.capitalizeString(flightRequest.destinationCity()))
                .build();
    }
}
