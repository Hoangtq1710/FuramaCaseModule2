package commons.validation.service_validation;

import java.util.regex.Pattern;

public class AmountPeopleValidation {
    //phải lớn hơn 0 và nhỏ hơn 20
    private static final String AMOUNT_PEOPLE_REGEX = "^([1-9]|1[0-9])$";
    public static boolean amountPeopleValidate(int amount) {
        return Pattern.matches(AMOUNT_PEOPLE_REGEX, Integer.toString(amount));
    }
}
