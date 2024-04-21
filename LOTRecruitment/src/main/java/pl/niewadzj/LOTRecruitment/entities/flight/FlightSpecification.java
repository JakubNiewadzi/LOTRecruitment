package pl.niewadzj.LOTRecruitment.entities.flight;

import org.springframework.data.jpa.domain.Specification;
import pl.niewadzj.LOTRecruitment.api.flight.records.FlightFilter;

import java.time.LocalDateTime;

public class FlightSpecification {

    private static final String START_CITY = "startCity";
    private static final String DESTINATION_CITY = "destinationCity";
    private static final String FLIGHT_NUMBER = "flightNumber";
    private static final String FLIGHT_DATE_TIME = "flightDateTime";
    private static final String FREE_SEATS = "freeSeats";

    private FlightSpecification() {
    }

    public static Specification<Flight> filterBy(FlightFilter flightFilter) {
        return Specification.where(hasStartCity(flightFilter.startCity()))
                .and(hasDestinationCity(flightFilter.destinationCity()))
                .and(hasFlightNumber(flightFilter.flightNumber()))
                .and(isBefore(flightFilter.maxFlightDateTime()))
                .and(isAfter(flightFilter.minFlightDateTime()))
                .and(hasFreeSeatsGreaterThanThan(flightFilter.minFreeSeats()))
                .and(hasFreeSeatsLessThanThan(flightFilter.maxFreeSeats()));
    }

    private static Specification<Flight> hasStartCity(String startCity) {
        return (root, query, criteriaBuilder) -> startCity == null || startCity.isEmpty() ?
                criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get(START_CITY), startCity);
    }

    private static Specification<Flight> hasDestinationCity(String destinationCity) {
        return (root, query, criteriaBuilder) -> destinationCity == null || destinationCity.isEmpty() ?
                criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get(DESTINATION_CITY), destinationCity);
    }

    private static Specification<Flight> hasFlightNumber(String flightNumber) {
        return (root, query, criteriaBuilder) -> flightNumber == null || flightNumber.isEmpty() ?
                criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get(FLIGHT_NUMBER), flightNumber);
    }

    private static Specification<Flight> isBefore(LocalDateTime maxDateTime) {
        return (root, query, criteriaBuilder) -> maxDateTime == null ?
                criteriaBuilder.conjunction() : criteriaBuilder.lessThanOrEqualTo(root.get(FLIGHT_DATE_TIME), maxDateTime);
    }

    private static Specification<Flight> isAfter(LocalDateTime minDateTime) {
        return (root, query, criteriaBuilder) -> minDateTime == null ?
                criteriaBuilder.conjunction() : criteriaBuilder.greaterThanOrEqualTo(root.get(FLIGHT_DATE_TIME), minDateTime);
    }

    private static Specification<Flight> hasFreeSeatsGreaterThanThan(Integer minFreeSeats) {
        return (root, query, criteriaBuilder) -> minFreeSeats == null ?
                criteriaBuilder.conjunction() : criteriaBuilder.greaterThanOrEqualTo(root.get(FREE_SEATS), minFreeSeats);
    }

    private static Specification<Flight> hasFreeSeatsLessThanThan(Integer maxFreeSeats) {
        return (root, query, criteriaBuilder) -> maxFreeSeats == null ?
                criteriaBuilder.conjunction() : criteriaBuilder.lessThanOrEqualTo(root.get(FREE_SEATS), maxFreeSeats);
    }
}
