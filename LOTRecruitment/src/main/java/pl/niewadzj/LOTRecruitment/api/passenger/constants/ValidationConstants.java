package pl.niewadzj.LOTRecruitment.api.passenger.constants;

public final class ValidationConstants {

    public static final String NULL_NAME_MESSAGE = "None of the names can be null";
    public static final String NAME_REGEX = "^[a-zA-Z-]{1,20}$";
    public static final String INVALID_NAME_MESSAGE = "Names can consist of only letters, '-' symbols, and be at most 20 characters long";
    public static final String COUNTRY_CODE_REGEX = "^\\+\\d{1,3}$";
    public static final String INVALID_COUNTRY_CODE_MESSAGE = "Country codes must start with a '+' symbol and be followed by one, two or three digits";
    public static final String NULL_COUNTRY_CODE_MESSAGE = "Country code cannot be null";
    public static final String NULL_NUMBER_MESSAGE = "Phone number cannot be null";
    public static final String NUMBER_REGEX = "^[0-9()-.\\s]+$";
    public static final String INVALID_NUMBER_MESSAGE = "Phone number can only consist of digits, parentheses, '-', '.' symbols or whitespace characters";

    private ValidationConstants() {
    }

}
