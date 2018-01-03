/**
 * 
 */
package com.practice.arrays;

/**
 * @author swamygorli 
 * Product Array Without using Division Operator
 *
 */
public class ProductArray {
	
	static final double EPS = 1e-9;

	private static void productArray(int a[], int n) {
		int left[] = new int[n];
		int result = 1;
		for (int i = 0; i < n; i++) {

			left[i] = result;
			result *= a[i];

		}

		result = 1;
		int temp = 1;

		for (int i = n - 1; i >= 0; i--) {
			temp = a[i];
			a[i] = result * left[i];
			result *= temp;
		}

		for (int i : a)
			System.out.print(i + " ");
	}

	private static void productArrayLog(int a[], int n) {
		double sum = 0;
		for (int i = 0; i < n; i++)
			sum += Math.log10(a[i]);
		for (int i = 0; i < n; i++)
			System.out.print((int) (EPS + Math.pow(10.00, sum - Math.log10(a[i]))) + " ");
	}

	public static void main(String[] args) {

		int a[] = { 10, 3, 5, 6, 2 };
		productArrayLog(a, a.length);
		productArray(a, a.length);

	}

}
