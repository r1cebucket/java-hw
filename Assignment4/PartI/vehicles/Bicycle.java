package vehicles;

public class Bicycle extends Vehicle {

    public Bicycle(String color) {
        super(2, color, 0.);
    }

    @Override
    public String toString() {
        return "Bicycle [id=" + this.getID() + ", wheels=" + this.getWheels() + ", color="
                + this.getColor()
                + ", cargoSpace=" + this.getCargoSpace() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Bicycle)) {
            return false;
        }
        Bicycle b = (Bicycle) o;
        return b.getWheels() == this.getWheels() && b.getColor() == this.getColor()
                && b.getCargoSpace() == this.getCargoSpace();
    }

    public String Pedal() {
        return "pedaling";
    }

}
