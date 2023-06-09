
class Permutations {

	public static int[][] getPermutations(int[] array) {

		int[][] permutations = new int[0][array.length]; // obviously your array will have more members
		return permutations;

	}

	private static int currentIndex = 0;

	public static void main(String[] args) {
		int[] startingArray = { 1, 2, 3, 4, 5 };
		int[][] result = getPermutations(startingArray);

	}
}
