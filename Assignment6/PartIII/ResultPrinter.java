import java.util.ArrayList;
import java.util.Collection;

public class ResultPrinter {
	MathOperation op;

	public ResultPrinter(MathOperation op) {
		this.op = op;
	}

	public void go(double a, double b) {
		System.out.println("result is " + this.op.operation(a, b));
	}

	public static void go(double a, double b, MathOperation op) {
		System.out.println("result is " + op.operation(a, b));
	}

	public static void go(Collection<Pair<Double, Double>> c, MathOperation op) {
		for (Pair<Double, Double> p : c) {
			System.out.println("result is " + op.operation(p.getA(), p.getB()));
		}
	}

	public static void main(String[] args) {
		// adding
		ResultPrinter rp = new ResultPrinter((a, b) -> {
			return a + b;
		});
		rp.go(3.0, 4.0);

		// multiplication
		ResultPrinter.go(4.0, 2.0, (a, b) -> {
			return a * b;
		});

		// devision
		ArrayList<Pair<Double, Double>> al = new ArrayList<Pair<Double, Double>>();
		Pair<Double, Double> p = new Pair<Double, Double>(3.0, 4.0);
		al.add(p);
		p = new Pair<Double, Double>(5.0, 6.0);
		al.add(p);
		p = new Pair<Double, Double>(7.0, 8.0);
		al.add(p);
		ResultPrinter.go(al, (a, b) -> {
			return a / b;
		});
	}
}
