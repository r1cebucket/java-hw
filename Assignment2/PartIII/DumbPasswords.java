
public class DumbPasswords {

	public static void printDumbPasswords(int m, int n) {
		for (int idx_1 = 1; idx_1 < m; idx_1++) {
			for (int idx_2 = 1; idx_2 < m; idx_2++) {
				for (int idx_3 = 0; idx_3 < n; idx_3++) {
					for (int idx_4 = 0; idx_4 < n; idx_4++) {
						for (int idx_5 = Math.max(idx_1, idx_2) + 1; idx_5 < m + 1; idx_5++) {
							System.out.print(String.format(
									"%d%d%c%c%d ",
									idx_1, idx_2, (char) (idx_3 + 'a'), (char) (idx_4 + 'a'), idx_5));
						}
					}
				}
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		printDumbPasswords(4, 2);
	}
}
