package pl.niewadzj.LOTRecruitment.utils;

public final class StringUtils {
    public static String capitalizeString(String toCapitalize) {
        return toCapitalize.substring(0, 1).toUpperCase() +
                toCapitalize.substring(1).toLowerCase();
    }

}
