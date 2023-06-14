
public class WordReverser {

	public static String reverseSentence(String sentence) {
		sentence = sentence.toLowerCase();
		String[] tokens = sentence.split(" ");
		String reversed = "";
		for (String token : tokens) {
			String tokenReversed = "";
			for (int i = token.length() - 1; i >= 0; i--) {
				tokenReversed += token.charAt(i);
			}
			reversed += tokenReversed + " ";
		}
		return reversed.trim();
	}

	public static void main(String[] args) {
		String result = reverseSentence("The quick brown fox jumps over the lazy dog");
		System.out.println(result);
	}

}
