package backtracking;

public class PossibleCombinationOfNumbersWhichSumToGivenNumber {

	public static void main(String[] args) {

		int n = 4;
		printAllCombination(n);

	}

	private static void printAllCombination(int n) {
		int[] combination = new int[n];
		printAll(n, combination, 0, 0);
	}

	private static void printAll(int n, int[] combination, int index, int currentSum) {

		if (currentSum > n) {
			return;
		}

		if (currentSum == n) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < index; i++) {
				sb.append(combination[i] + " ");
			}
			System.out.println(sb.toString());
			return;
		}

		int prev = index == 0 ? 1 : combination[index - 1];

		for (int i = prev; i <= n; i++) {
			combination[index] = i;
			printAll(n, combination, index + 1, currentSum + i);
		}

	}
}


/*output
 * 
1 1 1 1 
1 1 2 
1 3 
2 2 
4 
 * */
