public class Exercise02 {

    // 1. Create a method.
    // Name: printAll
    // Inputs: MoneyStorage[]
    // Output: void
    // Description: prints the details for each MoneyStorage in the array.

    public static void main(String[] args) {
        MoneyStorage[] storages = {
                // in this array, we can put a wallet and a mortgage
                new Wallet(3.25, "Red Wallet"),
                new Mortgage(320000, "1234-dfdf-8790-trtr"),
                // 2. Declare a third MoneyStorage here.
                new Wallet(2000, "Blue Wallet")
        };

        // Adding $100 to Wallet $3.25 + $100.00 = $103.25
        depositInAll(storages, 100.00);

        // 3. Pass storages as an argument to printAll.
        printAll(storages);
        // Sample Output
        // Red Wallet: 103.25
        // Mortgage #1234-dfdf-8790-trtr: -319900.0
        // [Some description]: [balance]
    }


    public static void depositInAll(MoneyStorage[] storages, double amount) {
        for (MoneyStorage storage : storages) {
            boolean returnedBoolean = storage.deposit(amount);
            System.out.printf("$%s has been deposited in account %s: %s.  \n", amount, storage.getDescription(), returnedBoolean);
        }
    }

    public static void printAll(MoneyStorage[] moneyStorages){
        // Takes a collection (an array), instead of using index, it builds it into the for loop.
        // don't have to find thing at correct location
        // For each item in this array, visit once

        // This does the same as the for loop below...

        // for (int i = 0; i<moneyStorages.length; i++){
        //    MoneyStorage storage = moneyStorages[i];
        // }

        for (MoneyStorage storage : moneyStorages){
            //System.out.println(storage);
            System.out.printf("%s: %s\n",storage.getDescription(), storage.getBalance());
        }
    }

}
