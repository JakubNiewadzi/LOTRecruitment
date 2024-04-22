package pl.niewadzj.LOTRecruitment.api.passenger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightResponse;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerController;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerService;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;

import java.util.List;

import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.ADD_PASSENGER_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.DELETE_PASSENGER_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.GET_FLIGHTS_BY_PASSENGER_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.GET_PASSENGERS_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.PASSENGER_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.UPDATE_PASSENGER_MAPPING;

@RestController
@RequiredArgsConstructor
@RequestMapping(PASSENGER_MAPPING)
@Tag(name = "Passenger", description = "Passenger management APIs")
public class PassengerControllerImpl implements PassengerController {

    private final PassengerService passengerService;

    @Override
    @GetMapping(GET_PASSENGERS_MAPPING)
    @Operation(summary = "Finds all passengers from database",
            description = "Connects with database to find all saved passengers")
    public final List<PassengerResponse> getAll() {
        return passengerService.getAll();
    }

    @Override
    @PostMapping(ADD_PASSENGER_MAPPING)
    @Operation(summary = "Adds a passenger to database",
            description = "Allows to add a valid passenger to database, when correct json is provided")
    public PassengerResponse addPassenger(@RequestBody @Valid PassengerRequest passengerRequest) {
        return passengerService.addPassenger(passengerRequest);
    }

    @Override
    @DeleteMapping(DELETE_PASSENGER_MAPPING)
    @Operation(summary = "Deletes a passenger from database",
            description = "Finds an existing passenger in database, by an id and then deletes it" +
                    "whenever a passenger who has reserved seats is deleted, it also frees those seats")
    public PassengerResponse deletePassenger(@RequestParam(defaultValue = "1") Long id) {
        return passengerService.deletePassenger(id);
    }

    @Override
    @PutMapping(UPDATE_PASSENGER_MAPPING)
    @Operation(summary = "Updates a passenger in database",
            description = "Finds an existing passenger in database, by its id and then overrides it with a new, updated one")
    public PassengerResponse updatePassenger(@RequestBody @Valid PassengerRequest passengerRequest,
                                             @RequestParam(defaultValue = "1") Long id) {
        return passengerService.updatePassenger(passengerRequest, id);
    }

    @Override
    @GetMapping(GET_FLIGHTS_BY_PASSENGER_MAPPING)
    @Operation(summary = "Gets a list of all flights on which given passenger has reserved a seat",
            description = "Returns a list of all flights, on which a seat has been reserved by a passenger with given id")
    public List<FlightResponse> getFlightsForPassenger(@RequestParam(defaultValue = "1") Long id) {
        return passengerService.getFlightsForPassenger(id);
    }

}
