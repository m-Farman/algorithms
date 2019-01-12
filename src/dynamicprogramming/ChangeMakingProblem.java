package dynamicprogramming;

public class ChangeMakingProblem {

	public static void main(String[] args) {

		int n = 16;
		int[] d = { 1, 5, 12, 25 };
		int result = findMinChange(d, n);
		System.out.println(result);
		System.out.println(getCoinUsed(d, n));

	}

	private static int findMinChange(int[] d, int n) {

		int[] mChange = new int[n + 1];
		for (int i = 1; i < mChange.length; i++) {
			mChange[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < d.length; j++) {
				if (d[j] > i) {
					break;
				}
				mChange[i] = Math.min(mChange[i], mChange[i - d[j]] + 1);
			}
		}

		return mChange[n];
	}

	private static String getCoinUsed(int[] d, int n) {

		int[] mChange = new int[n + 1];
		for (int i = 1; i < mChange.length; i++) {
			mChange[i] = Integer.MAX_VALUE;
		}
		int[] coin = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < d.length; j++) {
				if (d[j] > i) {
					break;
				}

				if (mChange[i - d[j]] + 1 < mChange[i]) {
					mChange[i] = mChange[i - d[j]] + 1;
					coin[i] = d[j];
				}

			}
		}
		int index = n;
		StringBuilder sb = new StringBuilder();
		while (index > 0) {
			sb.append(coin[index]);
			index -= coin[index];
			if (index > 0) {
				sb.append(",");
			}
		}

		return sb.toString();
	}
}


/*output
 * 
4
1,5,5,5
 * */
