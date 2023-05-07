package aufgabe;

import java.math.BigInteger;

public class IbanValidator {

    public static boolean isValidIban(String iban) {

        if (iban == null || iban.length() != 22) {
            return false;
        }

        if (!iban.substring(0, 2).equals("DE")) {
            return false;
        }


        String Prüf_Zahl = iban.substring(2, 4);

        String Bankleitzahl = iban.substring(4, 12);

        String Kontonummer = iban.substring(12);

        String rearrangedIban = Bankleitzahl + Kontonummer + "1314" + Prüf_Zahl;


        BigInteger number = new BigInteger(rearrangedIban);

        BigInteger remainder = number.remainder(BigInteger.valueOf(97));


        if (remainder.equals(BigInteger.valueOf(1))) {
            return true;
        }
        return false;
    }

}
