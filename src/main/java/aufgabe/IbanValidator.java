package aufgabe;

public class IbanValidator {

    public static boolean isValidIban(String iban) {

        if (iban == null || iban.length() != 22) {
            return false;
        }

        // Die IBAN beginnt immer mit dem Länderkennzeichen. Für Deutschland ist dies „DE“
        if (!iban.substring(0, 2).equals("DE")) {
            return false;
        }

        // 5. ve 6. karakterler kontrol rakamlarıdır ve harf içeremezler
        char fifthChar = iban.charAt(4);
        char sixthChar = iban.charAt(5);
        if (!Character.isDigit(fifthChar) || !Character.isDigit(sixthChar)) {
            return false;
        }

        //String countryCode = iban.substring(0, 2);

        String checkDigits = iban.substring(2, 4);

        String bankCode = iban.substring(4, 12);

        String accountNumber = iban.substring(12);

        String rearrangedIban = bankCode + accountNumber  + "1314" + checkDigits;

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

        return (98-checksum)  == Integer.parseInt(checkDigits);
    }
}

/*
https://gocardless.com/de/handbuch/artikel/iban-pruefziffer-berechnen-so-gehts/

Die IBAN-Prüfziffer berechnen: Das Modulo 97-Verfahren
Nehmen wir mal an, Sie haben nur die Bankleitzahl und die Kontonummer des Zahlungsempfängers sowie den Ländercode „DE“. Die Prüfziffer fehlt Ihnen jedoch. Natürlich können Sie dafür digitale IBAN-Rechner verwenden, die Sie auf verschiedenen Internetseiten finden. Tatsächlich gibt es jedoch auch eine Formel. Anhand dieses Beispiels zeigen wir Ihnen, wie Sie mit Hilfe des Modulo 97-Verfahrens die Prüfziffer der IBAN berechnen können.

Für dieses Beispiel nehmen wir folgende fiktive Kontodaten:

Bankleitzahl: 350 700 24

Kontonummer: 038 824 96 00

Wir wissen, dass die Bankleitzahl und die Kontonummer an Stelle 3 und 4 stehen. Zunächst stellen wir den Ländercode und die unbekannte Prüfziffer ans Ende dieser Stellen. Die Prüfziffer ersetzen wir durch zwei Nullen: „35070024 0388249600 DE00“

Für jeden Buchstaben des Alphabets gibt es eine zugeordnete Nummer, die ihn ersetzt. Der Buchstabe A bekommt die Nummer 10, der Buchstabe B die Nummer 11, der Buchstabe C die Nummer 12 und so weiter. Für DE ergibt sich dadurch: 13 und 14. Unsere IBAN sieht nun so aus: „35070024 0388249600 131400“

Diese 24-stellige Zahl wird nun durch 97 geteilt und der Rest wird ermittelt. Da die meisten Taschenrechner solche Zahlen nicht berechnen können, empfiehlt es sich, Excel zur Hilfe zu ziehen. In unserem Beispiel ist der Rest 54.

Haben Sie den Rest ermittelt, so subtrahieren Sie diesen von der ISO-genormten Zahl 98. Das ist Ihre Prüfziffer. In unserem Beispiel ist dies 44.

Die errechnete IBAN ist damit: DE44 35070024 0388249600.
 */