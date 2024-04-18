package pl.niewadzj.LOTRecruitment.api.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightService;
import pl.niewadzj.LOTRecruitment.api.flight.mapper.FlightMapper;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;
import pl.niewadzj.LOTRecruitment.entities.flight.repository.FlightRepository;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;
import pl.niewadzj.LOTRecruitment.entities.passenger.repository.PassengerRepository;
import pl.niewadzj.LOTRecruitment.exceptions.flight.FlightNotFoundException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.PassengerNotOnFlightException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.SeatsOccupiedException;
import pl.niewadzj.LOTRecruitment.exceptions.passenger.PassengerNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final FlightMapper flightMapper;

    @Override
    public final List<FlightResponse> getFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper)
                .toList();
    }

    @Override
    public final FlightResponse addFlight(FlightRequest flightRequest) {
        Flight flight = Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .flightDateTime(flightRequest.localDateTime())
                .freeSeats(flightRequest.amountOfSeats())
                .build();

        flight = flightRepository.saveAndFlush(flight);
        return flightMapper.apply(flight);
    }

    @Override
    public final FlightResponse updateFlight(FlightRequest flightRequest, Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException(id));

        flight.setFlightNumber(flightRequest.flightNumber());
        flight.setFlightDateTime(flightRequest.localDateTime());
        flight.setFreeSeats(flightRequest.amountOfSeats());

        flight = flightRepository.saveAndFlush(flight);
        return flightMapper.apply(flight);
    }

    @Override
    public final FlightResponse deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException(id));

        flightRepository.delete(flight);
        return flightMapper.apply(flight);
    }

    @Override
    public final FlightResponse reserveSeat(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));

        final Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException(passengerId));

        if (flight.getFreeSeats() <= 0) {
            throw new SeatsOccupiedException();
        }

        flight.setFreeSeats(flight.getFreeSeats() - 1);
        flight.getPassengers().add(passenger);
        flight = flightRepository.saveAndFlush(flight);
        
        return flightMapper.apply(flight);
    }

    @Override
    public final FlightResponse freeOccupiedSeat(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));

        final Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException(passengerId));

        if (!flight.getPassengers().remove(passenger)) {
            throw new PassengerNotOnFlightException();
        }

        flight.setFreeSeats(flight.getFreeSeats() + 1);
        flight = flightRepository.saveAndFlush(flight);

        return flightMapper.apply(flight);
    }
}
