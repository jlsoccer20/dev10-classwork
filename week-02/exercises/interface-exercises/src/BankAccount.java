public class BankAccount implements MoneyStorage{

    // Fields
    private double balance;
    private final String accountNumber;

    // Constructors
    public BankAccount(double startingBalance, String accountNumber) {
        this.balance = startingBalance;
        this.accountNumber = accountNumber;
    }

    // Getters

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription(){
        return String.format("Bank Account: %s", accountNumber);
    }

    public String getAccountNumber() {
        return String.format("Account Number: %s", accountNumber);
    }

    @Override
    public boolean deposit(double amount) {

        if (amount <= 0){
            return false;
        } else { // if (amount > 0)
            balance = balance + amount;
            return true;
        }

    }

    // Member Function - can access any Class Members
    @Override
    public double withdraw(double amountToWithdraw){
        double overdraw = 25.0;
        if (amountToWithdraw <= balance + overdraw){
            System.out.printf("Withdrew $%s from Account Number: %s\n", amountToWithdraw, accountNumber);
            balance = balance - amountToWithdraw;
            System.out.printf("Remaining balance: %s\n", balance);
            return amountToWithdraw;

        } else { // if (amountToWithdraw > balance + overdraw)
            System.out.printf("Withdraw request to withdraw $%s was rejected. \nYour balance is: %s\n", amountToWithdraw,balance);
            return 0.0;
        }
    }
}
