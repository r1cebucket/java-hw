package vehicles;

import java.util.ArrayList;
import java.util.Arrays;

public class Motorcycle extends Vehicle {
    private ArrayList<String> accessories;

    public Motorcycle(String color, String[] accessories) {
        super(2, color, 0);
        this.accessories = new ArrayList<>(Arrays.asList(accessories));
    }

    public ArrayList<String> getAccessories() {
        return this.accessories;
    }

    public void setAccessories(ArrayList<String> accessories) {
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return "Motorcycle [id=" + this.getID() + ", wheels=" + this.getWheels() + ", color="
                + this.getColor()
                + ", cargoSpace=" + this.getCargoSpace() + ", accessories=" + this.getAccessories() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Motorcycle)) {
            return false;
        }
        Motorcycle m = (Motorcycle) o;
        return m.getWheels() == this.getWheels() && m.getColor() == this.getColor()
                && m.getCargoSpace() == this.getCargoSpace() && m.getAccessories() == this.getAccessories();
    }

    public String TwistThrottle() {
        return "accelerating";
    }
}
