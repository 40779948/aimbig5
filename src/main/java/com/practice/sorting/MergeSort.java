/**
 * 
 */
package com.practice.sorting;

/**
 * @author swamygorli
 *
 */
public class MergeSort {

	private static void mergeSort(int a[], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {

		int n1 = mid - low + 1;
		int n2 = high - mid;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = a[i + low];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = a[mid + 1 + j];
		}

		int i = 0, j = 0, k = low;

		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;

		}

		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;

		}
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;

		}
	}

	public static void main(String[] args) {

		int a[] = { 4, 9, 3, 2, -7, 5, 6, 3 };

		mergeSort(a, 0, a.length - 1);

		for (int i : a)
			System.out.print(i + " ");

	}

}
