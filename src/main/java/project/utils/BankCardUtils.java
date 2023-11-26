package project.utils;

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
}
