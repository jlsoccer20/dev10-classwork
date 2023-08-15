import java.util.Arrays;

public class Hero {
    private final String name;
    private final Power[] powers; // 1D array with multiple powers


    // Constructors
    public Hero(String name, Power[] powers) {
        this.name = name;
        this.powers = powers;
    }

    // Getters
    public String getName(){

        return name;
    }

    public Power[] getPowers(){

        return powers;
    }


    public String toLine() {

        String powerStr = "";
        for (int i = 0; i < powers.length; i++) {
            if (i > 0) {
                powerStr += ",";
            }
            powerStr += powers[i].getName();
        }
        return powerStr;
    }
//        return "Hero{" +
//                "name='" + name + '\'' +
//                ", powers=" + Arrays.toString(powers) +
//                '}';




}
