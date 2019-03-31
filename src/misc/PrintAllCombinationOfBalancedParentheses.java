package misc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintAllCombinationOfBalancedParentheses {

	public static void main(String[] args) {
		System.out.println("-----all possible combination are-----");
		print(4);
	}

	private static void print(int n) {

		String[] combination = new String[n * 2];
		printAll(n, combination, 0, 0, 0);

	}

	private static void printAll(int n, String[] combination, int pCount, int nCount, int index) {

		if (nCount == n) {
			System.out.println(Stream.of(combination).collect(Collectors.joining()));
			return;
		}
		if (pCount > nCount) {
			combination[index] = "}";
			printAll(n, combination, pCount, nCount + 1, index + 1);
		}
		if (pCount < n) {
			combination[index] = "{";
			printAll(n, combination, pCount + 1, nCount, index + 1);
		}
	}
}


/*output
 * 
-----all possible combination are-----
{}{}{}{}
{}{}{{}}
{}{{}}{}
{}{{}{}}
{}{{{}}}
{{}}{}{}
{{}}{{}}
{{}{}}{}
{{}{}{}}
{{}{{}}}
{{{}}}{}
{{{}}{}}
{{{}{}}}
{{{{}}}}
 * 
 * 
 * */
