package dynamicprogramming;

public class EditDistance {

	public static void main(String[] args) {

		String initial = "Kitten";
		String finalResult = "Knitting";
		int count = findMinOperation(initial, finalResult);
		System.out.println(count);
	}

	private static int findMinOperation(String initial, String finalResult) {

		int[][] min = new int[initial.length() + 1][finalResult.length() + 1];

		int count = 0;
		for (int i = 0; i < initial.length(); i++) {
			for (int j = 0; j < finalResult.length(); j++) {
				if (initial.charAt(i) == finalResult.charAt(j)) {
					min[i + 1][j + 1] = min[i][j];
				} else {
					min[i + 1][j + 1] = 1 + Math.min(Math.min(min[i][j], min[i][j + 1]), min[i + 1][j]);
				}

			}
		}

		return min[initial.length()][finalResult.length()];
	}
}
