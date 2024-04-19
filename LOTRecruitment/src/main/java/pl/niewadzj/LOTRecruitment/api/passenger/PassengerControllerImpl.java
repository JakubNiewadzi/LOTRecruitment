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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/passengers")
@Tag(name = "Passenger", description = "Passenger management APIs")
public class PassengerControllerImpl implements PassengerController {

    private final PassengerService passengerService;

    @Override
    @GetMapping("/get")
    public final List<PassengerResponse> getAll() {
        return passengerService.getAll();
    }

    @Override
    @PostMapping("/add")
    public PassengerResponse addPassenger(@RequestBody @Valid PassengerRequest passengerRequest) {
        return passengerService.addPassenger(passengerRequest);
    }

    @Override
    @DeleteMapping("/delete")
    public PassengerResponse deletePassenger(@RequestParam Long id) {
        return passengerService.deletePassenger(id);
    }

    @Override
    @PutMapping("/update")
    public PassengerResponse updatePassenger(@RequestBody PassengerRequest passengerRequest,
                                             @RequestParam Long id) {
        return passengerService.updatePassenger(passengerRequest, id);
    }

}
