package Account;

public class CardAccount extends Account {
    private String cardNumber;
    private String cardType; 

    public CardAccount(int accountId, String accountHolder, String cardNumber, String cardType) {
        super(accountId, accountHolder);
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
