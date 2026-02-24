public class Peso20Dispenser implements DispenseChain {
    private DispenseChain chain;  

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 20) {
            int num = cur.getAmount() / 20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing " + num + " × ₱20");
            if (remainder != 0) {
                System.out.println("  → Cannot dispense remaining ₱" + remainder 
                                 + " (no smaller denomination available)");
            }
        } else if (cur.getAmount() > 0) {
            System.out.println("  → Cannot dispense ₱" + cur.getAmount() 
                             + " (amount below smallest bill ₱20)");
        }
        
    }
}