package pl.niewadzj.LOTRecruitment.api.flight.constants;

public final class ValidationConstants {

    public static final String FLIGHT_NUMBER_REGEX = "^LO\\d{2,4}$";
    public static final String INVALID_FLIGHT_NUMBER_MESSAGE = "Flight number must start with 'LO' and be followed by two, three or four digits";
    public static final String NULL_FLIGHT_NUMBER_MESSAGE = "Flight number cannot be null";
    public static final String NULL_FLIGHT_DATE_TIME_MESSAGE = "Flight date time cannot be null";
    public static final String NULL_CITY_MESSAGE = "City name cannot be null";
    public static final String CITY_REGEX = "^[a-zA-Z -]{1,40}$";
    public static final String INVALID_CITY_MESSAGE = "City name can consist of only letters, spaces and '-' symbols, and be at most 40 characters long";
    public static final int MIN_AMOUNT_OF_SEATS = 0;
    public static final String MIN_AMOUNT_OF_SEATS_MESSAGE = "Amount of seats must be a positive integer";
    public static final int MAX_AMOUNT_OF_SEATS = 500;
    public static final String MAX_AMOUNT_OF_SEATS_MESSAGE = "Amount of seats must be at most 500";

    private ValidationConstants() {
    }

}
