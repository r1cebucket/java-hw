public class ComplexNumber extends Number implements Cloneable {
	private double real;
	private double imaginary;

	public ComplexNumber() {
		this.real = 0;
		this.imaginary = 0;
	}

	public ComplexNumber(double real) {
		this.real = real;
		this.imaginary = 0;
	}

	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public double getReal() {
		return this.real;
	}

	public double getImaginary() {
		return this.imaginary;
	}

	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(this.real + c.real, this.imaginary + c.imaginary);
	}

	public ComplexNumber subtract(ComplexNumber c) {
		return new ComplexNumber(this.real - c.real, this.imaginary - c.imaginary);
	}

	public ComplexNumber multiply(ComplexNumber c) {
		return new ComplexNumber(this.real * c.real - this.imaginary * c.imaginary,
				this.real * c.imaginary + this.imaginary * c.real);
	}

	public ComplexNumber divide(ComplexNumber c) {
		return new ComplexNumber(
				(this.real * c.real + this.imaginary * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary),
				(this.imaginary * c.real - this.real * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary));
	}

	public double abs() {
		return Math.sqrt(real * real + imaginary * imaginary);
	}

	public ComplexNumber clone() {
		return new ComplexNumber(this.real, this.imaginary);
	}

	// implement Number
	public int intValue() {
		return (int) this.real;
	}

	public double doubleValue() {
		return this.real;
	}

	public float floatValue() {
		return (float) this.real;
	}

	public long longValue() {
		return (long) this.real;
	}

	@Override
	public String toString() {
		if (imaginary == 0) {
			return "" + real;
		}
		return real + "+i" + imaginary;
	}
}
