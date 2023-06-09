class Permutations {
	public static int[][] getPermutations(int[] array) {
		int size = 1;
		for (int i = array.length; i > 0; i--) {
			size *= i;
		}
		int[][] permutations = new int[size][0]; // obviously your array will have more members

		return permutations;
	}

	private static int currentIndex = 0;

	public static void main(String[] args) {
		int[] startingArray = { 1, 2, 3, 4, 5 };
		int[][] result = getPermutations(startingArray);
		System.out.println(result.length);
	}
}
