public class Power {
    private final String name;
    public Power(String name){
        this.name=name;
    }

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
