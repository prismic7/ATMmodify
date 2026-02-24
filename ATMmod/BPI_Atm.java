public class BPI_Atm {
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();

        
        int amount = 2970;

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount % 10 != 0) {
            System.out.println("Amount should be in multiples of 10.");
        } else {
            System.out.println("Dispensing ₱" + amount + ":");
            atmDispenser.dispense(new Currency(amount));
            System.out.println();
        }
    }
}