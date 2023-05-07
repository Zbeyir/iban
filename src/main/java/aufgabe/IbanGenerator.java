package aufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IbanGenerator {

    private static final int IBAN_LENGTH = 22;
    private static final String Länderkennzeichen = "DE";
    private static final int Bankleitzahl = 8;
    private static final int Kontonummer = 10;
    private static final int Prüf_Zahl = 2;

    private static final Random random = new Random();

    public static List<String> generateRandomIban(int count) {

        List<String> ibans = new ArrayList<>();

        for (int j = 0; j < count; j++) {

            StringBuilder builder = new StringBuilder(IBAN_LENGTH);

            builder.append(Länderkennzeichen);

            for (int i = 0; i < Prüf_Zahl; i++) {
                builder.append(random.nextInt(10));
            }

            for (int i = 0; i < Bankleitzahl; i++) {
                builder.append(random.nextInt(10));
            }

            for (int i = 0; i < Kontonummer; i++) {
                builder.append(random.nextInt(10));
            }

            ibans.add(builder.toString());
        }
        return ibans;
    }
}