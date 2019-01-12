package dynamicprogramming;

public class IntegerKnapSackProblem {

	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int w = 50;
		int maxValue = getMaxValue(val, wt, w);
		System.out.println(maxValue);
	}

	private static int getMaxValue(int[] val, int[] wt, int w) {

		int[][] mValue = new int[val.length + 1][w + 1];

		for (int i = 0; i <= val.length; i++) {
			for (int j = 0; j <= w; j++) {

				if (j == 0 || i == 0) {
					continue;
				}

				if (j >= wt[i - 1]) {
					mValue[i][j] = Math.max(mValue[i - 1][j], val[i - 1] + mValue[i - 1][j - wt[i - 1]]);
				} else {
					mValue[i][j] = mValue[i - 1][j];
				}

			}
		}
		return mValue[val.length][w];
	}
}
