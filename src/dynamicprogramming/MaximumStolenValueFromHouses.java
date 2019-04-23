package dynamicprogramming;

//https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
public class MaximumStolenValueFromHouses {

	public static void main(String[] args) {
		int arr[] = { 6, 7, 1, 3, 8, 2, 4 };

		int output = find(arr);
		System.out.println(output);
	}

	private static int find(int[] arr) {

		if (arr.length == 0) {
			return 0;
		}

		if (arr.length == 1) {
			return arr[0];
		}
		if (arr.length == 2) {
			return Math.max(arr[0], arr[0]);
		}

		int[] value = new int[arr.length];
		value[0] = arr[0];
		value[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < value.length; i++) {
			value[i] = Math.max(arr[i] + value[i - 2], value[i - 1]);
		}

		return value[arr.length - 1];
	}
}
