package aufgabe;

import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie die Anzahl der zu generierenden IBANs ein: ");
        int numIbans = scanner.nextInt();

        List<String> ibans = IbanGenerator.generateRandomIban(numIbans);

        for (String iban : ibans) {

            if (IbanValidator.isValidIban(iban)) {
                System.out.println("Valid ---> " + iban);

            } else {
                System.err.println("Invalid ---> " + iban);
            }
        }
    }
}
