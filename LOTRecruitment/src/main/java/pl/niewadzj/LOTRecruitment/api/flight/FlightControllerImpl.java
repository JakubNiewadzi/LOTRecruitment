package pl.niewadzj.LOTRecruitment.api.flight;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/getAll")
    public List<FlightResponse> getFlights() {
        return flightService.getFlights();
    }

    @Override
    @PostMapping("/addFlight")
    public void addFlight(@RequestBody FlightRequest flightRequest) {
        flightService.addFlight(flightRequest);
    }
}
