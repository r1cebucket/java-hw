package vehicles;

public class Cargocycle extends Bicycle {
    public Cargocycle(int whells, double cargoSpace, String color) {
        super(color);
        this.setWheels(whells);
        this.setCargoSpace(cargoSpace);
    }

    @Override
    public String toString() {
        return "Cargocycle [id=" + this.getID() + ", wheels=" + this.getWheels() + ", color="
                + this.getColor()
                + ", cargoSpace=" + this.getCargoSpace() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cargocycle)) {
            return false;
        }
        Cargocycle c = (Cargocycle) o;
        return c.getWheels() == this.getWheels() && c.getColor() == this.getColor()
                && c.getCargoSpace() == this.getCargoSpace();
    }
}
