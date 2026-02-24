public class ATMDispenseChain implements DispenseChain {
    private DispenseChain nextChain;

    public ATMDispenseChain() {
        // Create chain: largest → smallest denomination
        DispenseChain c1000 = new Peso1000Dispenser();
        DispenseChain c500  = new Peso500Dispenser();
        DispenseChain c200  = new Peso200Dispenser();
        DispenseChain c100  = new Peso100Dispenser();
        DispenseChain c50   = new Peso50Dispenser();
        DispenseChain c20   = new Peso20Dispenser();

        // Link them together
        c1000.setNextChain(c500);
        c500.setNextChain(c200);
        c200.setNextChain(c100);
        c100.setNextChain(c50);
        c50.setNextChain(c20);

        // Head of the chain
        this.nextChain = c1000;
    }

    @Override
    public void dispense(Currency currency) {
        nextChain.dispense(currency);
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }
}