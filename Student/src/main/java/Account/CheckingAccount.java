package Account;
public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(int accountId, String accountHolder, double overdraftLimit) {
        super(accountId, accountHolder);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            super.withdraw(amount);
        }
    }
}
