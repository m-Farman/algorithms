package dynamicprogramming;

import java.util.TreeMap;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		int count = findLIS(arr);
		System.out.println("Maximum sequence count : " + count);
		System.out.println("----------sequence with size-----------");
		findLISOutput(arr);
	}

	private static int findLIS(int[] arr) {

		int[] lis = new int[arr.length];

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < lis.length; i++) {
			max = Math.max(max, lis[i]);
		}

		return max;
	}

	private static void findLISOutput(int[] arr) {

		int[] lis = new int[arr.length];

		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		TreeMap<Integer, Integer> lseq = new TreeMap<>();
		int max = 0;
		for (int i = 0; i < lis.length; i++) {
			if (!lseq.containsKey(lis[i])) {
				lseq.put(lis[i], arr[i]);
			}
		}

		lseq.keySet().stream().forEach(k -> System.out.println(k + "  " + lseq.get(k)));
	}
}

/*
 * output
 * 
 * 
 Maximum sequence count : 6
----------sequence with size-----------
1  10
2  22
3  33
4  50
5  60
6  80
 * 
 */
