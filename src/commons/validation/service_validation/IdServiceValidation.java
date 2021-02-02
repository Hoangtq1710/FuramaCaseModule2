package commons.validation.service_validation;

import java.util.regex.Pattern;

public class IdServiceValidation {
    // SVXX-YYYY trong đó XX là VL || HO || RO, YYYY là các số từ 0-9 [\\d]{4}

    private static final String VILLA_REGEX = "^SVVL\\-[\\d]{4}$";
    private static final String HOUSE_REGEX = "^SVHO\\-[\\d]{4}$";
    private static final String ROOM_REGEX = "^SVRO\\-[\\d]{4}$";

    public static boolean idSerValidate(int serviceType,String id) {
        String regex = "";
        switch (serviceType) {
            case 1 :
                regex = VILLA_REGEX;
                break;
            case 2 :
                regex = HOUSE_REGEX;
                break;
            case 3 :
                regex = ROOM_REGEX;
                break;
        }
        return Pattern.matches(regex, id);
    }
}
