package arraylists;

import java.util.ArrayList;

import vehicles.*;

public class VehicleArraylist {

    public static void main(String[] args) {
        // this ArrayList MUST be parameterized
        ArrayList<Vehicle> vehiclesArrayList = new ArrayList<>();
        Car blueCar = new Car("blue", 20, 4);

        // a
        // 1 one red motorcycle with accessories “grip warmers” and “usb charger”
        vehiclesArrayList.add(new Motorcycle("red", new String[] { "grip warmers", "usb charger" }));
        // 2 blue cars with 4 doors and 20 cubic feet of cargo space
        for (int i = 0; i < 2; i++) {
            vehiclesArrayList.add(new Car("blue", 20., 4));
        }
        // 1 black bicycle
        vehiclesArrayList.add(new Bicycle("black"));
        // 2 green cargocycles with 3 wheels and 10 cubic feet of cargo space
        for (int i = 0; i < 2; i++) {
            vehiclesArrayList.add(new Cargocycle(3, 10., "green"));
        }
        // 1 gray car with 2 doors and 10 cubic feet of cargo space
        vehiclesArrayList.add(new Car("gray", 10, 2));
        // 1 white car with 4 doors and 25 cubic feet of cargo space
        vehiclesArrayList.add(new Car("white", 25, 4));

        // b: average cargo space of all the Car
        double totalCargoSpace = 0.0;
        int totalNum = 0;
        for (Vehicle v : vehiclesArrayList) {
            if (v instanceof Car) {
                totalNum += 1;
                totalCargoSpace += ((Car) v).getCargoSpace();
            }
        }
        System.out.println("Average cargo space of all cars is: " + (totalCargoSpace / totalNum));

        // c: Retain the 1 st blue Car object in a Car variable with the blue color, 4
        // doors, and 20 cubic feet of cargo space.
        System.out.println("\nBlue cars found:");
        for (int i = 0; i < vehiclesArrayList.size(); i++) {
            if (vehiclesArrayList.get(i).equals(blueCar)) {
                System.out.println(vehiclesArrayList.get(i).toString());
                vehiclesArrayList.remove(i--);
            }
        }

        // d
        System.out.println("\nAfter removing:");
        for (int i = 0; i < vehiclesArrayList.size(); i++) {
            System.out.println(vehiclesArrayList.get(i).toString());
        }
    }

}
