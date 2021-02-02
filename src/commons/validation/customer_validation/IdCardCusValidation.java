package commons.validation.customer_validation;

import java.util.regex.Pattern;

public class IdCardCusValidation {
    private static final String ID_CUS_REGEX = "^[\\d]{9}$";
    public static boolean idCusValidate(String id) {
        return Pattern.matches(ID_CUS_REGEX,id);
    }
}
