package dynamicprogramming;

public class RodCuttingProblem {

	public static void main(String[] args) {

		int[] size = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int value = getMaxProfit(size, price, 8);
		System.out.println(value);
		System.out.println("Sizes are : " + maxProfitSizes(size, price, 8));
		System.out.println("------new price-------");
		price = new int[] { 3, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(getMaxProfit(size, price, 8));
	}

	private static int getMaxProfit(int[] size, int[] price, int rodSize) {

		int[] cost = new int[rodSize + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= rodSize; i++) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < size.length; j++) {
				if (size[j] > i) {
					break;
				}
				max = Math.max(max, price[j] + cost[i - size[j]]);
			}
			cost[i] = max;
		}

		return cost[rodSize];
	}

	private static String maxProfitSizes(int[] size, int[] price, int rodSize) {

		int[] cost = new int[rodSize + 1];
		int[] sUsed = new int[rodSize + 1];

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= rodSize; i++) {
			max = Integer.MIN_VALUE;
			for (int j = 0; j < size.length; j++) {
				if (size[j] > i) {
					break;
				}
				if (max < price[j] + cost[i - size[j]]) {
					max = price[j] + cost[i - size[j]];
					sUsed[i] = size[j];
				}
			}
			cost[i] = max;
		}

		int index = rodSize;
		StringBuilder sb = new StringBuilder();
		while (index > 0) {
			sb.append(sUsed[index]);
			index -= sUsed[index];
			if (index > 0) {
				sb.append(",");
			}
		}

		return sb.toString();
	}

}

/*
 * output 
22
Sizes are : 2,6
------new price-------
24
 */
