package commons.validation.service_validation;

import java.util.regex.Pattern;

public class RentalCostValidation {
    // phải là số dương
    private static final String RENTAL_COST_REGEX = "^[\\d]+\\.[\\d]+$";
    public static boolean rentalCostValidate(double rentalCost) {
        return Pattern.matches(RENTAL_COST_REGEX, Double.toString(rentalCost));
    }
}
