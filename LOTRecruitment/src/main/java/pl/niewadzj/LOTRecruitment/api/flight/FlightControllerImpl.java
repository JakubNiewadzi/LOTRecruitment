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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flights")
@Tag(name = "Flight", description = "Flight management APIs")
public class FlightControllerImpl implements FlightController {

    private final FlightService flightService;

    @Override
    @GetMapping("/get")
    public final List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @Override
    @PostMapping("/add")
    public final FlightResponse addFlight(@RequestBody @Valid FlightRequest flightRequest) {
        return flightService.addFlight(flightRequest);
    }

    @Override
    @PutMapping("/update")
    public final FlightResponse updateFlight(@RequestBody @Valid FlightRequest flightRequest,
                                             @RequestParam Long id) {
        return flightService.updateFlight(flightRequest, id);
    }

    @Override
    @DeleteMapping("/delete")
    public final FlightResponse deleteFlight(@RequestParam Long id) {
        return flightService.deleteFlight(id);
    }

    @Override
    @PatchMapping("/reserveSeat")
    public final FlightResponse reserveSeat(@RequestParam Long flightId,
                                            @RequestParam Long passengerId) {
        return flightService.reserveSeat(flightId, passengerId);
    }

    @Override
    @PatchMapping("/freeOccupiedSeat")
    public FlightResponse freeOccupiedSeat(@RequestParam Long flightId,
                                           @RequestParam Long passengerId) {
        return flightService.freeOccupiedSeat(flightId, passengerId);
    }
}
