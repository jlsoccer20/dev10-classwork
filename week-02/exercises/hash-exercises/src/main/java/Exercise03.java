import learn.Vehicle;
import learn.VehicleRepository;

import java.util.HashMap;

public class Exercise03 {

    // 1. Create a method to print all Vehicles in a HashMap<String, Vehicle>.
    // Consider making it `public` so you can use it in other exercises.

    public static void main(String[] args) {
        HashMap<String, Vehicle> vehicleMap = VehicleRepository.getMap();

        // 2. Print `vehicleMap` using your "print all" method.
        printVehicles(vehicleMap);

    }

    public static void printVehicles(HashMap<String, Vehicle> vehicleMap){
        // Loop over keys in a hash map
        for (String vin : vehicleMap.keySet()) { // list of vins
            System.out.printf("Vin Number: %s, %s%n", vin, vehicleMap.get(vin)); // prints out list of vins
        }
        for (Vehicle v : vehicleMap.values()){
            if (v.getMake().equalsIgnoreCase("Ford") && v.getYear() >= 2000){
                System.out.println(v);
            }
        }

    }
}

