public class EstimateLog {
	public static double estimateLog(double x) { //
		double result = 0.;
		int n;
		for (n = 1;; n++) {
			double increasement = Math.pow(-1, n + 1) * Math.pow(x, n) / n;
			result += increasement;
			if (Math.abs(increasement) < .0001) {
				break;
			}
		}
		System.out.println(String.format("ln(%.2f) is ", x + 1.) + result);
		System.out.print(String.format(
				"it requires %d iterations to estimate ln(%.2f) within .0001\n\n",
				n, x + 1.));
		return result;
	}

	public static void main(String[] args) {
		for (double x = 0.; x < .91; x += .01) {
			EstimateLog.estimateLog(x);
		}

	}
}
