package commons.validation.customer_validation;

import java.util.regex.Pattern;

public class GenderCusValidation {
    private static final String GENDER_REGEX = "^Male|Female|Unknown$";

    public static String genderStandardized(String gender) {
        StringBuilder result = new StringBuilder();

        char[] c = gender.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (i == 0) {
                result.append(Character.toUpperCase(c[0]));
                continue;
            }
            c[i] = Character.toLowerCase(c[i]);
            result.append(c[i]);
        }
        return result.toString();
    }
    public static boolean genderValidate(String gender) {
        if (gender.contains(" ")) {
            return false;
        }
        return Pattern.matches(GENDER_REGEX,genderStandardized(gender));
    }
}
