package Account;

public class BankTest {
    public static void main(String[] args) {
        //  Account
        Account account = new Account(1, "Bat");
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Дансны үлдэгдэл: " + account.getBalance());

        //  SavingsAccount
        SavingsAccount savings = new SavingsAccount(2, "Bat", 5);
        savings.deposit(1000);
        System.out.println("Хадгаламжийн дансны үлдэгдэл: " + savings.getBalance());
        System.out.println("Interest: " + savings.calculateInterest());

        //  CheckingAccount
        CheckingAccount checking = new CheckingAccount(3, "Bat", 200);
        checking.deposit(1000);
        checking.withdraw(1100);
        System.out.println("Дансны үлдэгдэл шалгах: " + checking.getBalance());

        //  CardAccount
        CardAccount cardAccount = new CardAccount(4, "Bat", "1234-5678-9012-3456", "Credit");
        cardAccount.deposit(1000);
        cardAccount.withdraw(0);
        System.out.println("Картын дансны үлдэгдэл: " + cardAccount.getBalance());
        System.out.println("Картын дугаар: " + cardAccount.getCardNumber());
        System.out.println("Картын төрөл: " + cardAccount.getCardType());
    }
}
