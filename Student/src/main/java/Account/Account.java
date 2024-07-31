package Account;
public class Account {
    private int accountId;
    private String accountHolder;
    private double balance;

    public Account(int accountId, String accountHolder) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
