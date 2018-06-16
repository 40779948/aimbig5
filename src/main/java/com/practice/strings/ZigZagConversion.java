package com.practice.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swamygorli on 6/16/18.
 */
public class ZigZagConversion {

    private static void printRowByRow(String s, int rows) {

        boolean goingDown = false;

        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < Math.min(rows, s.length()); i++)
            sbList.add(new StringBuilder());

        int currow = 0;

        for (char c : s.toCharArray()) {

            sbList.get(currow).append(c);
            if (currow == 0 || currow == rows - 1)
                goingDown = !goingDown;

            currow += goingDown ? 1 : -1;
        }

        for (StringBuilder sb : sbList)
            System.out.print(sb.toString());

    }

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        printRowByRow(s, 3);
        System.out.println();
        printRowByRow(s, 4);


    }
}
