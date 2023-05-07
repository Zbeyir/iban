package aufgabe;


public class Test {

    public static void main(String[] args) {

        int numIbans = 100;


        for (int i = 0; i < numIbans; i++) {
            String iban = IbanGenerator.generateRandomIban();

            if (IbanValidator.isValidIban(iban)) {
                System.out.println("Valid ---> " + iban);


            } else {
                System.err.println("Invalid ---> " + iban);

            }
        }
    }
}