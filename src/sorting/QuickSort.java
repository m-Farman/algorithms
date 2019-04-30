package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int arr[] = { 3, 1, 4, 12, 5, 13, 8, 6 };

		System.out.println("Before QuickSort : " + Arrays.toString(arr));
		sort(arr, 0, arr.length - 1);
		System.out.println("After QuickSort : " + Arrays.toString(arr));

	}

	private static void sort(int[] arr, int start, int end) {

		if (start < end) {
			int p = partition(arr, start, end);
			sort(arr, start, p - 1);
			sort(arr, p + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {

		int pivot = arr[end];
		int left = start;
		int right = end - 1;
		while (left < right) {

			while (left < end && arr[left] <= pivot) {
				left++;
			}
			while (right >= start && arr[right] > pivot) {
				right--;
			}

			if (left < right) {
				swap(arr, left, right);
			}
		}

		swap(arr, left, end);

		return left;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}

/*output
 * 
Before QuickSort : [3, 1, 4, 12, 5, 13, 8, 6]
After QuickSort : [1, 3, 4, 5, 6, 8, 12, 13]
 * */
