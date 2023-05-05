package aufgabe;

import aufgabe.IbanGenerator;
import aufgabe.IbanValidator;

public class Test {

    public static void main(String[] args) {

        int numIbans = 100;

        for (int i = 0; i < numIbans; i++) {
            String iban = IbanGenerator.generateRandomIban();

            if (IbanValidator.isValidIban(iban)) {
                System.out.println("Valid");
            } else {
                System.err.println("Invalid");
            }
        }
    }
}