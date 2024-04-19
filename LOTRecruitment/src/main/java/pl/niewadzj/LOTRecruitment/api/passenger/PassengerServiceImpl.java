package pl.niewadzj.LOTRecruitment.api.passenger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerService;
import pl.niewadzj.LOTRecruitment.api.passenger.mapper.PassengerMapperImpl;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;
import pl.niewadzj.LOTRecruitment.entities.passenger.Passenger;
import pl.niewadzj.LOTRecruitment.entities.passenger.repository.PassengerRepository;
import pl.niewadzj.LOTRecruitment.exceptions.passenger.PassengerNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerMapperImpl passengerMapper;
    private final PassengerRepository passengerRepository;

    @Override
    public final List<PassengerResponse> getAll() {
        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::mapEntityToResponse)
                .toList();
    }

    @Override
    public final PassengerResponse addPassenger(PassengerRequest passengerRequest) {
        Passenger passenger = passengerMapper
                .mapRequestToEntity(passengerRequest);

        passenger = passengerRepository.saveAndFlush(passenger);

        return passengerMapper.mapEntityToResponse(passenger);
    }

    @Override
    public PassengerResponse deletePassenger(Long id) {
        final Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException(id));

        passengerRepository.deleteById(id);

        return passengerMapper.mapEntityToResponse(passenger);
    }

    @Override
    public PassengerResponse updatePassenger(PassengerRequest passengerRequest, Long id) {
        final Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException(id));

        Passenger updatedPassenger = passengerMapper.mapRequestToEntity(passengerRequest);
        updatedPassenger.setId(passenger.getId());

        updatedPassenger = passengerRepository.saveAndFlush(updatedPassenger);
        return passengerMapper.mapEntityToResponse(updatedPassenger);
    }
}
