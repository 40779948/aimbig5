package com.practice.arrays;

/**
 * Created by swamygorli on 6/9/18.
 */
public class FirstNonRepeatingChar {


    private static void printFirstNonRepeatingChar(String word) {

        int[] track = new int[26];

        for (int k : track) {
            k = -1;
        }


        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            int pos = ch - 'a';

            if (track[pos] != -1)
                track[pos] = i;
            else
                track[pos] = -2;

        }

        int min = Integer.MAX_VALUE;

        for (int k : track) {
            if (k >= 0)
                min = Math.min(min, k);
        }

        System.out.println(word.charAt(min));

    }


    public static void main(String[] args) {

        String str = "construct";
        printFirstNonRepeatingChar(str);

    }


}
