
public class MyInitials {
	public static void main(String[] args) {
		String[] letterH = {"H   H", "H   H", "H   H", "HHHHH", "H   H", "H   H", "H   H"};
		String[] letterF = {"FFFFF", "F    ", "F    ", "FFF  ", "F    ", "F    ", "F    "};
		for (int i = 0; i < 7; i++) {
			System.out.println(letterH[i] + " " + letterF[i]);
		}
	}
}
