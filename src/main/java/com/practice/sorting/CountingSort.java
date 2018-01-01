/**
 * 
 */
package com.practice.sorting;

/**
 * @author swamygorli
 * This will work for only non-negative Integers
 *
 */
public class CountingSort {

	private static void countingSort(int a[], int len) {

		int max = Integer.MIN_VALUE;

		for (int i : a)
			max = Math.max(max, i);

		max = max + 1;

		int count[] = new int[max];
		int out[] = new int[len];

		for (int i : a)
			count[i]++;

		for (int k = 1; k < max; k++)
			count[k] += count[k - 1];

		for (int i : a)
			out[--count[i]] = i;

		for (int i = 0; i < len; i++)
			a[i] = out[i];

	}

	public static void main(String[] args) {

		int a[] = { 1, 4, 6, 2, 1, 2, 4, 6, 3, 7, 9, 1 };
		countingSort(a, a.length);

		for (int k : a)
			System.out.print(k + " ");

	}

}
