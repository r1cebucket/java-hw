package vehicles;

public class Vehicle {
	private int id;
	private static int nextID = 0;
	private int wheels;
	private String color;
	private double cargoSpace;

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

	public Vehicle() {
		this.id = Vehicle.nextID++;
	}

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		System.out.println(v1.getID());
		System.out.println(v2.getID());
	}

}
