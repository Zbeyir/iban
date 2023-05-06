package aufgabe;

import java.util.Random;

public class IbanGenerator {

    private static final int IBAN_LENGTH = 22;
    private static final String COUNTRY_CODE = "DE";
    private static final int BANK_CODE_LENGTH = 8;
    private static final int ACCOUNT_NUMBER_LENGTH = 10;
    private static final int prüfZahl = 2;

    private static final Random random = new Random();

    public static String generateRandomIban() {
        StringBuilder builder = new StringBuilder(IBAN_LENGTH);

        builder.append(COUNTRY_CODE);

        builder.append("00");


       /*for (int i = 0; i < prüfZahl ; i++) {
            builder.append(random.nextInt(10));

        }

        */

        for (int i = 0; i < BANK_CODE_LENGTH; i++) {
            builder.append(random.nextInt(10));
        }

        for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
            builder.append(random.nextInt(10));
        }

        return builder.toString();
    }
}
