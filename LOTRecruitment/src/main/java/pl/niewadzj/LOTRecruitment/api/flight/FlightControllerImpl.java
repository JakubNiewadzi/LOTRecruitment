package pl.niewadzj.LOTRecruitment.api.flight;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightFilter;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightRequest;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;

import java.time.LocalDateTime;
import java.util.List;

import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.ADD_FLIGHT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.DELETE_FLIGHT_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.flight.constants.FlightMappings.FILTER_FLIGHTS;
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
    @Operation(summary = "Finds all flights from database",
            description = "Connects with database to find all saved flights")
    public final List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @Override
    @PostMapping(ADD_FLIGHT_MAPPING)
    @Operation(summary = "Adds a flight to database",
            description = "Allows to add a valid flight to database, when correct json is provided")
    public final FlightResponse addFlight(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.addFlight(flightRequest);
    }

    @Override
    @PutMapping(UPDATE_FLIGHT_MAPPING)
    @Operation(summary = "Updates a flight in database",
            description = "Finds an existing flight in database, by its id and then overrides it with a new, updated one")
    public final FlightResponse updateFlight(@RequestBody @Valid FlightRequest flightRequest,
                                             @RequestParam(defaultValue = "1") Long id) {
        return flightService.updateFlight(flightRequest, id);
    }

    @Override
    @DeleteMapping(DELETE_FLIGHT_MAPPING)
    @Operation(summary = "Deletes a flight from database",
            description = "Finds an existing flight in database, by its id and then deletes it")
    public final FlightResponse deleteFlight(@RequestParam(defaultValue = "1") Long id) {
        return flightService.deleteFlight(id);
    }

    @Override
    @PatchMapping(RESERVE_SEAT_MAPPING)
    @Operation(summary = "Reserves a seat for existing passenger",
            description = "Performs a reservation of a seat for passenger, if passenger has not already reserved it. " +
                    "Also checks validity of a reservation")
    public final FlightResponse reserveSeat(@RequestParam(defaultValue = "1") Long flightId,
                                            @RequestParam(defaultValue = "1") Long passengerId) {
        return flightService.reserveSeat(flightId, passengerId);
    }

    @Override
    @PatchMapping(FREE_OCCUPIED_SEAT_MAPPING)
    @Operation(summary = "Frees a reserved seat by a passenger",
            description = "Makes occupied seat free, if a passenger has it reserved. " +
                    "Also checks validity of a freeing")
    public FlightResponse freeOccupiedSeat(@RequestParam(defaultValue = "1") Long flightId,
                                           @RequestParam(defaultValue = "1") Long passengerId) {
        return flightService.freeOccupiedSeat(flightId, passengerId);
    }

    @Override
    @GetMapping(GET_PASSENGERS_BY_FLIGHT_MAPPING)
    @Operation(summary = "Gets a list of all passengers on a flight",
            description = "Returns a list of all passengers, who have reserved a seat for a flight with given id")
    public List<PassengerResponse> getPassengersByFlight(@RequestParam(defaultValue = "1") Long flightId) {
        return flightService.getPassengersByFlight(flightId);
    }

    @Override
    @GetMapping(FILTER_FLIGHTS)
    @Operation(summary = "Filters a flight by given filter arguments",
            description = "Returns all flights that are filtered by given criteria, " +
                    "none of the criteria is mandatory to perform a valid filtration")
    public List<FlightResponse> filterFlights(@RequestParam(required = false) @Parameter(example = "2024-04-22T12:00:00.000Z") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime minFlightDateTime,
                                              @RequestParam(required = false) @Parameter(example = "2025-04-22T12:00:00.000Z") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime maxFlightDateTime,
                                              @RequestParam(required = false) @Parameter(example = "Cracow") String startCity,
                                              @RequestParam(required = false) @Parameter(example = "Warsaw") String destinationCity,
                                              @RequestParam(required = false) @Parameter(example = "LO1234") String flightNumber,
                                              @RequestParam(required = false) @Parameter(example = "2") Integer minFreeSeats,
                                              @RequestParam(required = false) @Parameter(example = "100") Integer maxFreeSeats) {

        FlightFilter flightFilter = FlightFilter.builder()
                .minFlightDateTime(minFlightDateTime)
                .maxFlightDateTime(maxFlightDateTime)
                .startCity(startCity)
                .destinationCity(destinationCity)
                .minFreeSeats(minFreeSeats)
                .maxFreeSeats(maxFreeSeats)
                .flightNumber(flightNumber)
                .build();

        return flightService.filterFlights(flightFilter);
    }
}
