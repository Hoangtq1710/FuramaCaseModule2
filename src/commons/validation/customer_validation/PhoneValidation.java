package commons.validation.customer_validation;

import java.util.regex.Pattern;

public class PhoneValidation {
    private static final String PHONE_REGEX = "^0([\\d]{9})$";
    public static boolean phoneValidate(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }
}
