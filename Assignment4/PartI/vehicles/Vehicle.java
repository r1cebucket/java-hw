package vehicles;

public class Vehicle {
	private int id;
	private static int nextID = 0;

	private int wheels;
	private String color;
	private double cargoSpace;

	public Vehicle(int wheels, String color, double cargoSpace) {
		this.id = nextID++;
		this.wheels = wheels;
		this.color = color;
		this.cargoSpace = cargoSpace;
	}

	public int getID() {
		return this.id;
	}

	public int getWheels() {
		return this.wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCargoSpace() {
		return this.cargoSpace;
	}

	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = cargoSpace;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", wheels=" + wheels + ", color=" + color + ", cargoSpace=" + cargoSpace + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Vehicle)) {
			return false;
		}
		Vehicle v = (Vehicle) o;
		return v.getWheels() == this.getWheels() && v.getColor() == this.getColor()
				&& v.getCargoSpace() == this.getCargoSpace();
	}
}
