package project.utils;

import java.util.Calendar;

/**
 * Utility class for bank card operations.
 * This class includes a method to validate bank card numbers using the Luhn algorithm.
 * The Luhn algorithm is a simple checksum formula used to validate a variety of identification numbers,
 * most notably credit card numbers.
 */
public class BankCardUtils {
    /**
     * Validates a bank card number using the Luhn algorithm.
     *
     * @param cardNumber The bank card number to validate.
     * @return true if the card number is valid according to the Luhn algorithm, false otherwise.
     */
    public static boolean isValidCardNumber(String cardNumber) {
        // First check that the card number length is 16 digits
        if (cardNumber == null || cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            return false; // Card number must be 16 digits
        }

        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public static boolean isValidExpiryDate(int month, int year) {
        // Get the current year and month
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int currentMonth = now.get(Calendar.MONTH) + 1;

        // Check month and year
        if (month < 1 || month > 12) {
            return false;// Months should be between 1 and 12
        }
        if (year < currentYear || year > currentYear + 10) {
            return false; // It is assumed that the effective year will not exceed 10 years beyond the current year.
        }
        if (year == currentYear && month < currentMonth) {
            return false; // If this is the current year, the month cannot be earlier than the current month.
        }

        return true;
    }

    public static boolean isValidSecurityCode(String securityCode) {
        // Check if the security code is a 3 or 4 digit number
        return securityCode != null && securityCode.matches("\\d{3,4}");
    }
}
