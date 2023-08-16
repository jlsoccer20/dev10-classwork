public class Vault implements MoneyStorage{

    // Defines a scope, which is the class


    // declaring "fields", which belongs in the scope
    // these are "member variables"
    private double balance;
    private String description;

    // Constructor
    public Vault(double balance, String description) {
        this.balance = balance;
        this.description = description;
    } // <--- curly braces defines a new scope

    // Getters - get stuff
    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0.0){
            balance += amount;
            return true;
        }
        //deposit must be positive value
        // if negative or zero, return false
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if(amount <= 0.0){
            return 0;
        }
        // this grabs teh smaller of the two numbers (balance vs amount)
        amount = Math.min(balance, amount);
        balance -= amount;

        return amount;
    }
}
