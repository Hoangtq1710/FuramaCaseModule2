package commons.validation.service_validation;

import java.util.regex.Pattern;

public class NameValidation {
    //phải viết hoa kí tự đầu và các kí tự còn lại viết thường
    private static final String NAME_REGEX = "^[A-Z][a-z]*$";
    public static boolean nameSerValidate(String name) {
        return Pattern.matches(NAME_REGEX,name);
    }
}
