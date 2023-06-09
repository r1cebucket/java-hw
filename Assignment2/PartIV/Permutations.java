import java.util.Arrays;

class Permutations {
	public static int[][] getPermutations(int[] array) {
		int size = 1;
		for (int i = array.length; i > 0; i--) {
			size *= i;
		}
		int[][] permutations = new int[size][array.length]; // obviously your array will have more members
		int[] used = new int[array.length];

		dfs(permutations, used, array, new int[array.length], 0);

		return permutations;
	}

	public static void dfs(int[][] permutations, int[] used, int[] array, int[] perm, int idxNext) { // next idx of
																										// perm
		if (allUsed(used)) {
			// System.out.println(Arrays.toString(perm));
			permutations[currentIndex] = Arrays.copyOf(perm, perm.length);
			currentIndex += 1;
			return;
		}
		for (int i = 0; i < array.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				perm[idxNext] = array[i];
				dfs(permutations, used, array, perm, idxNext + 1);
				used[i] = 0;
			}
		}
	}

	public static boolean allUsed(int[] used) {
		for (int i = 0; i < used.length; i++) {
			if (used[i] == 0) {
				return false;
			}
		}
		return true;
	}

	private static int currentIndex = 0;

	public static void main(String[] args) {
		int[] startingArray = { 1, 2, 3, 4, 5 };
		int[][] result = getPermutations(startingArray);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
