package pl.niewadzj.LOTRecruitment.api.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightService;
import pl.niewadzj.LOTRecruitment.api.flight.mapper.FlightMapper;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;
import pl.niewadzj.LOTRecruitment.entities.flight.repository.FlightRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightResponse> getFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper)
                .toList();
    }

    @Override
    public void addFlight(FlightRequest flightRequest) {
        final Flight flight = Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .flightDateTime(flightRequest.localDateTime())
                .freeSeats(flightRequest.amountOfSeats())
                .build();

        flightRepository.saveAndFlush(flight);
    }
}
