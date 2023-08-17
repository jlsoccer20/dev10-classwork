public class Exercise08 {

    public static void main(String[] args) {
        // COMPOSITION vs. INHERITANCE

        /* Take a look inside the Person class.
        The initial developer made an interesting design decision. In order to allow payment to a Person, they made
        the Person class extend Wallet. Currently, a Person is-a Wallet. While it sort of works - we can give a Person
        money via the `deposit` method and ask for money via `withdraw` - it's a little strange. A Person isn't truly
        a Wallet. A Person has-a Wallet.
         */

        // 1. Refactor the Person class so that it no longer extends Wallet. Instead, solve the problem using
        // composition - a has-a relationship.
        // 2. While you're at it, change Wallet to the more generic MoneyStorage.
        // Person may optionally have a MoneyStorage.

        Wallet wallet = new Wallet (0.0, "Sidonnie's Wallet");
        Person p = new Person("Sidonnie", "Antonietti", wallet);
        p.getWallet().deposit(125.85);
        System.out.println(p.getFullName());
        System.out.println(p.getWallet().p.getDescription());
        System.out.println(p.getWallet().p.getBalance());
    }
}
