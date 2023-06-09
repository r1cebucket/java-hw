
public class PressureChange {

	public static double calculatePressureChange(double diameter, double length, double dyanmicViscosity,
			double flowRate) {
		// double fD = .04;
		double pressureChange = 0;
		double pi = Math.PI;

		pressureChange = 128 * dyanmicViscosity * flowRate * length / pi / Math.pow(diameter, 4);

		return pressureChange;
	}

	public static void main(String[] args) {
		double diameter = .0254;
		double length = 5;
		double mu = 8.9E-4;
		double q = 5e-4;

		double pressureChange = calculatePressureChange(diameter, length, mu, q);
		System.out.println("The change in pressure is: "
				+ pressureChange);

	}
}
