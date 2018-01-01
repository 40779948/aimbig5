/**
 * 
 */
package com.practice.sorting;

/**
 * @author swamygorli
 *
 */
public class QuickSort {

	private static void quickSort(int a[], int low, int high) {

		if (low < high) {
			int pi = partition(a, low, high);
			quickSort(a, low, pi - 1);
			quickSort(a, pi + 1, high);

		}

	}

	private static int partition(int[] a, int low, int high) {

		int i = low - 1;
		int pivot = a[high];

		for (int j = low; j < high; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;

			}
		}

		int temp = a[i + 1];
		a[i + 1] = a[high];
		a[high] = temp;

		return i + 1;
	}

	public static void main(String[] args) {

		int a[] = { 4, 9, 3, 2, -7, 5, 6, 3 };

		quickSort(a, 0, a.length - 1);

		for (int i : a)
			System.out.print(i + " ");

	}

}
