public class Balloon {
    private String color;
    private double psi; // double for decimal "int"

    // Constructor
    public Balloon(String color) {
        this.color = color;
    }

    // Getters

    public String getColor() {
        return color;
    }

    public double getPsi() {
        if (psi > 16.0){
            return Double.POSITIVE_INFINITY;
        } else{
            return psi;
        }
    }

    // Math.random() 0.0(inclusive) to 1.0 (exclusive)

    // adds a random value to the psi field between 0,0 and 5,0
    public void inflate(){
        this.psi = this.psi + (Math.random() * 5.0);
    }

    public boolean isExploded(){
        return psi > 16.0;
    }
}
