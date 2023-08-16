package learn.interfaces.power;

public class USOutlet implements PowerSource{
    @Override
    public double getVolts() {
        return 120.0;
    }
}
