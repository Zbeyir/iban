package aufgabe;

public class IbanValidator {

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
}