package dynamicprogramming;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "Kitten";
		String str2 = "Knitting";
		int count = findLCS(str1, str2);
		System.out.println(count);
		System.out.println(findLCS("wxyxzz", "zyxwxwzy"));
	}

	private static int findLCS(String str1, String str2) {

		int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {

				if (str1.charAt(i) == str2.charAt(j)) {
					lcs[i + 1][j + 1] = lcs[i][j] + 1;
				} else {
					lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
				}

			}
		}

		return lcs[str1.length()][str2.length()];
	}
}

/*output
 *
5
3
 * */
 