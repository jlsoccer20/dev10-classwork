public class App {
    public static void main(String[] args) {
        // 1. instantiation (variable declaration)
        NationalForest one = new NationalForest("Allegheny", "Pennsylvania", 513655);
        NationalForest two = new NationalForest("Angeles", "California", 661565);
        NationalForest three = new NationalForest("Angelina", "Texas", 154140);
        NationalForest four = new NationalForest();
        NationalForest five = new NationalForest("Dixie", "Utah", 123);

        System.out.println(one.toLine());
        System.out.println(two.toLine());
        System.out.println(three.toLine());
        System.out.println(four.toLine());


        // 2. Set a public field
        // access the field "name" using the dot operator, assign its value by assigning string literal " "
        // one.name = "Allegheny";
        // one.location = "Pennsylvania";
        // one.acres = 513655;

        //NationalForest two = new NationalForest();
        //two.name = "Angeles";

        //NationalForest three = new NationalForest();
        //three.name = "Angelina";

        //String format ="name: %s, location: %s, acres: %s%n";

        // 3. read each public field
        // each object's fields have different values, which are read using dot operator
        // System.out.printf(format, one.name, one.location, one.acres);
        // System.out.printf(format, two.name, two.location, two.acres);
        // System.out.printf(format, three.name, three.location, three.acres);
        // System.out.printf(format, four.name, four.location, four.acres);

    }
}
