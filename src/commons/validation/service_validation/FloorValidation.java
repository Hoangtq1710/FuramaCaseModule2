package commons.validation.service_validation;

import java.util.regex.Pattern;

public class FloorValidation {
    // phải là số nguyên dương (< 99)
    private static final String FLOOR_REGEX = "^[1-9][0-9]?$";
    public static boolean floorValidate(int floor) {
        return Pattern.matches(FLOOR_REGEX, Integer.toString(floor));
    }
}
