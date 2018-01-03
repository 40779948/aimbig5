/**
 * 
 */
package com.practice.arrays;

/**
 * @author swamygorli
 *
 */
public class MajorityElement {

	private static int getElement(int a[]) {

		int ele = a[0];
		int count = 1;

		for (int i = 1; i < a.length; i++) {

			if (a[i] == ele)
				count++;
			else
				count--;
			if (count == 0) {
				ele = a[i];
				count = 1;
			}

		}

		return ele;
	}

	private static String getMajorityElement(int a[], int ele) {

		int length = a.length;
		String result = "";
		int count = 0;

		for (int i : a) {
			if (i == ele)
				count++;
			if (count > length / 2) {

				result = "Majority Element is: " + ele;
				return result;

			}
		}
		result = "No majority Element Found..";
		return result;

	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 1, 1, 3, 1, 2, 2, 1 };

		System.out.println(getMajorityElement(a, getElement(a)));

	}

}
