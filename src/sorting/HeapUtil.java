package sorting;

import java.util.concurrent.ThreadLocalRandom;

public abstract class HeapUtil {

	public static int[] getRandomMinHeap(int size, int min, int max) {

		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(min, max);
		}
		minHeapify(array);
		return array;
	}

	public static int[] getRandomMaxHeap(int size, int min, int max) {

		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(min, max);
		}
		maxHeapify(array);
		return array;
	}

	public static void minHeapify(int[] array) {
		heapify(array, true);
	}

	public static void maxHeapify(int[] array) {
		heapify(array, false);
	}

	private static void heapify(int[] array, boolean isMinHeap) {
		int n = array.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(array, n, i, isMinHeap);
		}
	}

	public static void heapify(int[] array, int length, int index, boolean isMinHeap) {

		int left = 2 * index + 1;
		int right = 2 * index + 2;

		int min = index, tmp;
		if (left < length && (isMinHeap ? array[index] > array[left] : array[index] < array[left])) {
			min = left;
		}
		if (right < length && (isMinHeap ? array[min] > array[right] : array[min] < array[right])) {
			min = right;
		}

		if (min != index) {
			tmp = array[index];
			array[index] = array[min];
			array[min] = tmp;
			heapify(array, length, min, isMinHeap);
		}

	}

}
