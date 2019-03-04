package misc;

import java.util.Stack;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		String exp = "10 + 2 * 6";
		double output = processExpression(exp);
		System.out.println(output);
		System.out.println(processExpression("100 * ( 2 + 12 ) / 14"));
	}

	private static double processExpression(String expression) {

		char[] chars = expression.toCharArray();
		Stack<Integer> values = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == ' ') {
				continue;
			}

			if (chars[i] == '(') {
				operators.push(chars[i]);
			} else if (chars[i] == ')') {

				while (!operators.isEmpty() && operators.peek() != '(') {
					values.push(evaluate(operators.pop(), values.pop(), values.pop()));
				}
				operators.pop();
			} else if (chars[i] >= '0' && chars[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
					sb.append(chars[i++]);
				}
				values.push(Integer.parseInt(sb.toString().trim()));

			} else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {

				while (!operators.isEmpty() && hasPrecedence(chars[i], operators.peek())) {
					values.push(evaluate(operators.pop(), values.pop(), values.pop()));
				}
				operators.push(chars[i]);
			}
		}

		while (!operators.isEmpty()) {
			values.push(evaluate(operators.pop(), values.pop(), values.pop()));
		}

		return values.pop();
	}

	private static Integer evaluate(Character peek, Integer b, Integer a) {

		switch (peek) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			break;
		}

		return 0;
	}

	private static boolean hasPrecedence(Character op1, Character op2) {

		if (op2 == '(' || op2 == ')') {
			return false;
		}
		if ((op1 == '/' || op1 == '*') && (op2 == '+' || op1 == '-')) {
			return false;
		}
		return true;
	}

}
