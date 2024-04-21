package pl.niewadzj.LOTRecruitment.api.flight.constants;

public final class FlightMappings {

    public static final String FLIGHTS_MAPPING = "/api/v1/flights";
    public static final String GET_FLIGHTS_MAPPING = "/getAll";
    public static final String GET_PASSENGERS_BY_FLIGHT_MAPPING = "/getPassengersByFlight";
    public static final String ADD_FLIGHT_MAPPING = "/add";
    public static final String UPDATE_FLIGHT_MAPPING = "/update";
    public static final String DELETE_FLIGHT_MAPPING = "/delete";
    public static final String RESERVE_SEAT_MAPPING = "/reserveSeat";
    public static final String FREE_OCCUPIED_SEAT_MAPPING = "/freeOccupiedSeat";
    public static final String FILTER_FLIGHTS = "/filterFlights";

    private FlightMappings() {
    }

}
