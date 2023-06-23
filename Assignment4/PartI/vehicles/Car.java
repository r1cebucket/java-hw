package vehicles;

public class Car extends Vehicle {
    private int doors;

    public Car(String color, double cargoSpace, int doors) {
        super(4, color, cargoSpace);
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car [id=" + this.getID() + ", wheels=" + this.getWheels() + ", color="
                + this.getColor()
                + ", cargoSpace=" + this.getCargoSpace() + ", doors=" + this.getDoors() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Car)) {
            return false;
        }
        Car c = (Car) o;
        return c.getWheels() == this.getWheels() && c.getColor() == this.getColor()
                && c.getCargoSpace() == this.getCargoSpace() && c.getDoors() == this.getDoors();
    }

    public String PressGasPedal() {
        return "accelerating";
    }
}
