package dynamicprogramming;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MaximumContiguousSubsequence {

	public static void main(String[] args) {

		int[] array = { -6, 2, -4, 1, 3, -1, 5, -1 };
		int max = findMscLength(array);
		System.out.println(max);
		System.out.println(getMcs(array));

	}

	private static String getMcs(int[] array) {
		int[] sum = new int[array.length];
		int max = sum[0] = array[0], index = 0;
		for (int i = 1; i < array.length; i++) {

			if (sum[i - 1] + array[i] > array[i]) {
				sum[i] = sum[i - 1] + array[i];
			} else {
				sum[i] = array[i];
			}
			if (max < sum[i]) {
				max = sum[i];
				index = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		while (max != 0) {
			sb.append(array[index]);
			max -= array[index--];
			if (max != 0) {
				sb.append(",");
			}
		}
		return sb.toString();
	}

	private static int findMscLength(int[] array) {

		int[] sum = new int[array.length];
		int max = sum[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}
}
