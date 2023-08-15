public class Pokemon {
    private int dexNumber;
    private String name;
    private String primaryType;
    private String secondaryType;

    private String[] types = new String[2];

    // Empty Constructor
    public Pokemon(){

    }
    // Constructors
    public Pokemon(int dexNumber, String name, String primaryType, String secondaryType) {
        this.dexNumber = dexNumber;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
    }

    // Getters
    public int getDexNumber() {
        return dexNumber;
    }
    public String getName() {
        return name;
    }

    public String getPrimaryType() {
        return primaryType;
    }
    public String getSecondaryType() {
        return secondaryType;
    }

    public void setDexNumber(int dexNumber) {
        this.dexNumber = dexNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrimaryType(String primaryType) {
        this.primaryType = primaryType;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public void setSecondaryType(String secondaryType){
        this.secondaryType = secondaryType;
    }


    // Generate toString()
    @Override
    public String toString() {
        return "Pokemon{" +
                "dexNumber=" + dexNumber +
                ", name='" + name + '\'' +
                ", primaryType='" + primaryType + '\'' +
                ", secondaryType='" + secondaryType + '\'' +
                '}';
    }
}
