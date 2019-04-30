package sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {

		int[] arr = { 3, 12, 4, 6, 2, 89, 1, 8 };
		System.out.println("Input array is " + Arrays.toString(arr));
		heapSort(arr);
		System.out.println("Ouput array is " + Arrays.toString(arr));

	}

	private static void heapSort(int[] arr) {

		HeapUtil.maxHeapify(arr);

		for (int i = arr.length - 1; i >= 0; i--) {
			int tmp = arr[i];
			arr[i] = arr[0];
			arr[0] = tmp;
			HeapUtil.heapify(arr, i, 0, false);
		}

	}
}


/*output
 * 
Input array is [3, 12, 4, 6, 2, 89, 1, 8]
Ouput array is [1, 2, 3, 4, 6, 8, 12, 89]
 * */
 