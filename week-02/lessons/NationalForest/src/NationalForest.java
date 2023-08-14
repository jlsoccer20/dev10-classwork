//[access modifier] class [name]{   }
public class NationalForest{

    // Class-level variables ("fields") ("member variables") ("members of a class")
    // Default values:
    // String = null;
    // int = 0;
    // boolean = false;
    private String name;
    //[access modifier][type name][name];
    private String location;
    private int acres;

    // "getters"
    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public int getAcres(){
        return acres;
    }

    public void setAcres(int acres) {
        if (acres > 0 ){
            this.acres = acres;
        }
    }

    // These lines deal with fewer parameters, else program breaks :(
    // These are called constructors:
    public NationalForest() {
        this("Unknown", "Unknown", -1);
    }
    public NationalForest(String name) {
        this(name, "Unknown", -1);
    }
    public NationalForest(String name, int acres) {
        this(name, "Unknown", acres);
    }

    public NationalForest(String name, String location, int acres) {
        this.name = name;
        this.location = location;
        this.acres = acres;
    }
    public int getSquareKilometers() {
        return (int) (this.acres/247.1);
    }

    public String toLine() {
        return String.format("name: %s, location: %s, acres: %s, km²: %s", name, location, acres,
                getSquareKilometers());
    }


}
