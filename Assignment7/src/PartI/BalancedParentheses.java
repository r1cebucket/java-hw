package PartI;

import java.util.Stack;

public class BalancedParentheses {

	public static boolean isBalanced(String inString) {
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < inString.length(); i++) {
			switch (inString.charAt(i)) {
				case '(':
					s.push('(');
					break;
				case ')':
					if (s.isEmpty()) {
						return false;
					}
					s.pop();
			}
		}
		return s.isEmpty();
	}

	public static void main(String[] args) {
		boolean result = isBalanced("(()()()())"); // true
		System.out.println(result);
		result = isBalanced("(((())))"); // true
		System.out.println(result);
		result = isBalanced("((((((())"); // false
		System.out.println(result);
		result = isBalanced(")((((((())"); // false
		System.out.println(result);
	}
}
