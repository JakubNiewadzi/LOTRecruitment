package pl.niewadzj.LOTRecruitment.api.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightMapper;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightService;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerMapper;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;
import pl.niewadzj.LOTRecruitment.entities.flight.Flight;
import pl.niewadzj.LOTRecruitment.entities.flight.repository.FlightRepository;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;
import pl.niewadzj.LOTRecruitment.entities.passenger.repository.PassengerRepository;
import pl.niewadzj.LOTRecruitment.exceptions.flight.FlightAlreadyStartedException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.FlightNotFoundException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.PassengerNotOnFlightException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.SeatAlreadyReservedException;
import pl.niewadzj.LOTRecruitment.exceptions.flight.SeatsOccupiedException;
import pl.niewadzj.LOTRecruitment.exceptions.passenger.PassengerNotFoundException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final FlightMapper flightMapper;

    @Override
    public List<FlightResponse> getFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper::mapEntityToResponse)
                .toList();
    }

    @Override
    public FlightResponse addFlight(FlightRequest flightRequest) {
        Flight flight = flightMapper.mapRequestToEntity(flightRequest);

        flight = flightRepository.saveAndFlush(flight);

        return flightMapper.mapEntityToResponse(flight);
    }

    @Override
    public FlightResponse updateFlight(FlightRequest flightRequest, Long id) {
        flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException(id));

        Flight updatedFlight = flightMapper.mapRequestToEntity(flightRequest);
        updatedFlight.setId(id);

        updatedFlight = flightRepository.saveAndFlush(updatedFlight);
        return flightMapper.mapEntityToResponse(updatedFlight);
    }

    @Override
    public FlightResponse deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFoundException(id));

        flightRepository.deleteById(id);

        return flightMapper.mapEntityToResponse(flight);
    }

    @Override
    @Transactional
    public FlightResponse reserveSeat(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));

        final Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException(passengerId));

        validateReservation(flight, passenger);

        flight.setFreeSeats(flight.getFreeSeats() - 1);
        flight.getPassengers().add(passenger);
        flight = flightRepository.saveAndFlush(flight);

        return flightMapper.mapEntityToResponse(flight);
    }

    @Override
    @Transactional
    public FlightResponse freeOccupiedSeat(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));

        final Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new PassengerNotFoundException(passengerId));

        validateSeatFreeing(flight, passenger);

        flight.setFreeSeats(flight.getFreeSeats() + 1);
        flight = flightRepository.saveAndFlush(flight);

        return flightMapper.mapEntityToResponse(flight);
    }

    @Override
    public List<PassengerResponse> getPassengersByFlight(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFoundException(flightId));

        return flight.getPassengers()
                .stream()
                .map(passengerMapper::mapEntityToResponse)
                .toList();
    }

    private void validateReservation(Flight flight, Passenger passenger) {
        if (flight.getFreeSeats() <= 0) {
            throw new SeatsOccupiedException();
        }

        if (flight.getPassengers().contains(passenger)) {
            throw new SeatAlreadyReservedException();
        }

        if (flight.getFlightDateTime().isBefore(LocalDateTime.now())) {
            throw new FlightAlreadyStartedException();
        }
    }

    private void validateSeatFreeing(Flight flight, Passenger passenger) {
        if (flight.getFlightDateTime().isBefore(LocalDateTime.now())) {
            throw new FlightAlreadyStartedException();
        }

        if (!flight.getPassengers().remove(passenger)) {
            throw new PassengerNotOnFlightException();
        }
    }
}
