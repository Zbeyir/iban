package aufgabe;

import java.util.Random;

public class Iban {

    private static final int IBAN_LENGTH = 22;
    private static final String COUNTRY_CODE = "DE";
    private static final int BANK_CODE_LENGTH = 8;
    private static final int ACCOUNT_NUMBER_LENGTH = 10;

    private static final Random random = new Random();


    public static String generateRandomIban() {
        StringBuilder builder = new StringBuilder(IBAN_LENGTH);


        builder.append(COUNTRY_CODE);


        builder.append("00");


        for (int i = 0; i < BANK_CODE_LENGTH; i++) {
            builder.append(random.nextInt(10));
        }


        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }


    public static boolean isValidIban(String iban) {

        String countryCode = iban.substring(0, 2);


        String checkDigits = iban.substring(2, 4);


        String bankCode = iban.substring(4, 12);


        String accountNumber = iban.substring(12);


        String rearrangedIban = accountNumber + bankCode + countryCode + checkDigits;

        int checksum = 0;
        for (int i = 0; i < rearrangedIban.length(); i++) {
            char c = rearrangedIban.charAt(i);
            int n;
            if (c >= '0' && c <= '9') {
                n = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                n = c - 'A' + 10;
            } else {

                return false;
            }
            checksum = (checksum * 10 + n) % 97;
        }

        return checksum == 1;
    }


    public static void main(String[] args) {

        int numIbans = 100;

        for (int i = 0; i < numIbans; i++) {

            String iban = generateRandomIban();

            
            if (isValidIban(iban)) {
                System.out.println("Valid");

            } else {
                System.err.println("Invalid");
            }

        }
    }


}
