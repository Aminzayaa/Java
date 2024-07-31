package Account;
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountId, String accountHolder, double interestRate) {
        super(accountId, accountHolder);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}
