package pl.niewadzj.LOTRecruitment.api.passenger;

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
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerController;
import pl.niewadzj.LOTRecruitment.api.passenger.interfaces.PassengerService;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerRequest;
import pl.niewadzj.LOTRecruitment.api.passenger.records.PassengerResponse;

import java.util.List;

import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.ADD_PASSENGER_MAPPING;
import static pl.niewadzj.LOTRecruitment.api.passenger.constants.PassengerMappings.DELETE_PASSENGER_MAPPING;
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
    public final List<PassengerResponse> getAll() {
        return passengerService.getAll();
    }

    @Override
    @PostMapping(ADD_PASSENGER_MAPPING)
    public PassengerResponse addPassenger(@RequestBody @Valid PassengerRequest passengerRequest) {
        return passengerService.addPassenger(passengerRequest);
    }

    @Override
    @DeleteMapping(DELETE_PASSENGER_MAPPING)
    public PassengerResponse deletePassenger(@RequestParam Long id) {
        return passengerService.deletePassenger(id);
    }

    @Override
    @PutMapping(UPDATE_PASSENGER_MAPPING)
    public PassengerResponse updatePassenger(@RequestBody @Valid PassengerRequest passengerRequest,
                                             @RequestParam Long id) {
        return passengerService.updatePassenger(passengerRequest, id);
    }

}
