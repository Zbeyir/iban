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


/*

Aufgabenstellung Programmierung
Für die Erzeugung von Testdaten soll ein einfacher IBAN-Generator in Python entwickelt werden.

Es soll hierbei lediglich ein Prototyp entwickelt werden, so dass zunächst eine Beschränkung auf deutsche IBANs ausreichend ist.

Das Programm soll aus einem Hauptprogramm und mindestens einer Klasse für die Erzeugung und Überprüfung von IBANs beinhalten.
Es soll dabei eine Methode zur Erzeugung von zufälligen IBANs erstellt werden.
Die Anzahl der zu erzeugenden IBANs soll beim Aufruf der Methode frei wählbar sein.

Eine weitere Methode soll eine IBAN als Übergabeparameter entgegennehmen und deren Validität prüfen.
Das entsprechende Ergebnis soll zurückgegeben werden.
Das Hauptprogramm soll lediglich die beiden o.g. Methoden aufrufen
und beispielhaft 100 gültige IBANs erzeugen sowie diese anschließend auf Validität prüfen.
Anmerkungen


Die Generierung und Prüfung der IBANs soll selbst implementiert werden.
Es sollen also keine entsprechenden Libraries verwendet werden.
Es ist ausreichend, wenn die Prüfziffern der IBAN berechnet werden,
die Berechnung der Prüfziffern der Kontonummern selbst, kann dagegen vernachlässigt werden.
Das Programm kann sich auf die Kommandozeile beschränken, eine grafische Benutzeroberfläche ist nicht erforderlich.
 */
