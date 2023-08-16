package learn.interfaces.power;

public class Battery implements PowerSource{

    private double volts;

    public Battery(double volts){
        this.volts = volts;
    }

    @Override
    public double getVolts() {
        return volts;
    }
}
