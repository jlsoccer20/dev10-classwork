import java.util.Scanner;

public class Exercise10 {

    public static void main(String[] args) {
        // USPS
        // Below is an abbreviated version of the US Postal Service retail parcel rates:
        /*
        Lbs | Zones 1&2 | Zone 3
        ===============
        1      $7.50      $7.85
        2       8.25       8.70
        3       8.70       9.70
        4       9.20      10.55
        5      10.20      11.30
        */

        // 1. Collect the parcel lbs and zone (1, 2, or 3) from the user.
        // 2. Add `if`/`else if`/`else` logic to cover all rates.
        // Use whatever strategy you think is best. You can create compound conditions or nest if/else statements.
        // If a lbs/zone combo does not exist, print a warning message for the user.

        Scanner console = new Scanner(System.in);

        System.out.print("Enter parcel weight (1 to 5): ");
        int weight = Integer.parseInt(console.nextLine());

        System.out.print("Enter Zone you wish to ship to (1, 2, or 3): ");
        int zone = Integer.parseInt(console.nextLine());

        if ((weight < 1 || weight > 5) || (zone < 1 || zone > 3)){
            System.out.println("out of range!");
        }

        switch (zone){
            case 1, 2 ->{
                switch(weight){

                }
            }
            case 3 ->{

            }
        }

    }
}
