package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {

		List<String> input = Arrays.asList("*34", "+1*23", "+12");
		System.out.println(prefixToPostfix(input));
	}

	public static List<String> prefixToPostfix(List<String> prefixes) {

		List<String> output = new ArrayList<>(prefixes.size());

		for (String prefix : prefixes) {
			output.add(preToPost(prefix));
		}
		return output;
	}

	public static String preToPost(String exp) {

		Stack<String> s = new Stack<String>();
		int length = exp.length();
		for (int i = length - 1; i >= 0; i--) {
			if (isOperator(exp.charAt(i))) {
				String op1 = s.peek();
				s.pop();
				String op2 = s.peek();
				s.pop();

				String temp = op1 + op2 + exp.charAt(i);
				s.push(temp);
			} else {
				s.push(exp.charAt(i) + "");
			}
		}

		return s.peek();
	}

	public static boolean isOperator(char x) {
		switch (x) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}
}
