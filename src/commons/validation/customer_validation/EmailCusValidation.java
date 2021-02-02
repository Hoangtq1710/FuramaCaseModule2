package commons.validation.customer_validation;

import java.util.regex.Pattern;

public class EmailCusValidation {
    // chưa full
    private static final String EMAIL_REGEX = "^[\\d\\w]+[\\d\\w+_.-]*@[a-z]+\\.[a-z]+$";
    public static boolean emailCusValidate(String email) {
        return Pattern.matches(EMAIL_REGEX,email);
    }
}
