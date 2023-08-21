public class Power {
    private final String name;

    // Constructor
    public Power(String name){
        this.name=name;
    }

    // Getter
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Power{" +
                "name='" + name + '\'' +
                '}';
    }
}
