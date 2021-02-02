package commons.validation.service_validation;

import java.util.regex.Pattern;

public class AreaValidation {
    //phải là số thực và lớn hơn 30m2
    private static final String AREA_REGEX = "^(([\\d]*[\\d]([\\d]))+|[3-9])[\\d]\\.[\\d]+$";
    public static boolean areaValidate(double area) {
        return Pattern.matches(AREA_REGEX, Double.toString(area));
    }
}
