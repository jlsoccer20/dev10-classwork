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
        return psi;
    }

    // Math.random() 0.0(inclusive) to 1.0 (exclusive)
    public void inflate(){
        this.psi = this.psi + (Math.random() * 5.0);
    }

    public boolean isExploded(){
        return psi > 16.0;
    }
}
