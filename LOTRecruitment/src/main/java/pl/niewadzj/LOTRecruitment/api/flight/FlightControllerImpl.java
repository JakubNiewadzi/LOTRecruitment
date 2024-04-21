package pl.niewadzj.LOTRecruitment.api.flight;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightController;
import pl.niewadzj.LOTRecruitment.api.flight.interfaces.FlightService;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;

import java.util.List;

import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.ADD_FLIGHT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.DELETE_FLIGHT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.FLIGHTS_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.FREE_OCCUPIED_SEAT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.GET_FLIGHTS_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.GET_PASSENGERS_BY_FLIGHT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.RESERVE_SEAT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.UPDATE_FLIGHT_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(FLIGHTS_MAPPING)
@Tag(name = "Flight", description = "Flight management APIs")
public class FlightControllerImpl implements FlightController {

    private final FlightService flightService;

    @Override
    @GetMapping(GET_FLIGHTS_MAPPING)
    public final List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @Override
    @PostMapping(ADD_FLIGHT_MAPPING)
    public final FlightResponse addFlight(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.addFlight(flightRequest);
    }

    @Override
    @PutMapping(UPDATE_FLIGHT_MAPPING)
    public final FlightResponse updateFlight(@RequestBody @Valid FlightRequest flightRequest,
                                             @RequestParam Long id) {
        return flightService.updateFlight(flightRequest, id);
    }

    @Override
    @DeleteMapping(DELETE_FLIGHT_MAPPING)
    public final FlightResponse deleteFlight(@RequestParam Long id) {
        return flightService.deleteFlight(id);
    }

    @Override
    @PatchMapping(RESERVE_SEAT_MAPPING)
    public final FlightResponse reserveSeat(@RequestParam Long flightId,
                                            @RequestParam Long passengerId) {
        return flightService.reserveSeat(flightId, passengerId);
    }

    @Override
    @PatchMapping(FREE_OCCUPIED_SEAT_MAPPING)
    public FlightResponse freeOccupiedSeat(@RequestParam Long flightId,
                                           @RequestParam Long passengerId) {
        return flightService.freeOccupiedSeat(flightId, passengerId);
    }

    @Override
    @GetMapping(GET_PASSENGERS_BY_FLIGHT_MAPPING)
    public List<PassengerResponse> getPassengersByFlight(@RequestParam Long flightId) {
        return flightService.getPassengersByFlight(flightId);
    }
}
