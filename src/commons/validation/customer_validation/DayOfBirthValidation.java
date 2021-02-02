package commons.validation.customer_validation;

import java.util.Date;
import java.util.regex.Pattern;

public class DayOfBirthValidation {

    private static final String DOB_REGEX = "^[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}$";

    public static boolean dobChecking(String dob) {
        Date date = new Date();
        int day = Integer.parseInt(dob.substring(0,2));
        int month = Integer.parseInt(dob.substring(3,5));
        int year = Integer.parseInt(dob.substring(6,10));

        int currentYear = date.getYear() + 1900;
        int currentMonth = date.getMonth() + 1;
        int currentDay = date.getDay();

        if (day < 1 || day > 31 || month < 1 || month > 12 || year <= 1900 || (year > (currentYear - 18))) {
            return false;
        }
        if (currentYear - 18 == year) {
            if (month > currentMonth) {
                return false;
            } else if (month == currentMonth) {
                if (day > currentDay) {
                    return false;
                }
            }
        }

        if (!checkingLeapYear(year)) {
            if (month == 2 && day > 28) {
                return false;
            }
        } else if (month == 2 && day > 29){
            return false;
        }
        if ((month == 2 || month == 4 || month == 6 || month == 9 || month == 11) && (day == 31)) {
            return false;
        }

        return true;
    }

    private static boolean checkingLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean dobValidate(String dob) {
        if (Pattern.matches(DOB_REGEX,dob)) {
            return dobChecking(dob);
        }
        return false;
    }
}
