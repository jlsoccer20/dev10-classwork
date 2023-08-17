public class Person {

    private final String firstName;
    private final String lastName;

    private final Wallet wallet;

    public Person(String firstName, String lastName, Wallet wallet) {
        // Wallet constructor
                this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public boolean depositToWallet(double amount){
        wallet.deposit(amount);
        return true;
    }

    public boolean withdrawFromWallet(double amount){
        if(amount <=5.0){
            wallet.withdraw(amount);
            return true;
        }
    }
    public MoneyStorage getWallet() {
    }
}
