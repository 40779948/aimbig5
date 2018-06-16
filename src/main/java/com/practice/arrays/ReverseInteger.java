package com.practice.arrays;

/**
 * Created by swamygorli on 6/16/18.
 */
public class ReverseInteger {

    private static int reverseInteger(int n) {
        int rev = 0;
        while (n != 0) {

            int pop = n % 10;
            n /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            rev = rev * 10 + pop;

        }
        return rev;
    }

    public static void main(String[] args) {
        int n = 678910;
        System.out.println(reverseInteger(n));
    }
}
