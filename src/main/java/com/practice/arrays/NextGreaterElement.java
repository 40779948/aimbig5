package com.practice.arrays;

import java.util.Stack;

/**
 * Created by swamygorli on 6/9/18.
 */
public class NextGreaterElement {


    private static void printNextGreaterElement(int a[]) {

        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);

        for (int i = 1; i < a.length; i++) {
            Integer pop = stack.peek();

            while (!stack.isEmpty() && pop < a[i])

            {
                stack.pop();
                System.out.println(pop + " :: " + a[i]);
                if (!stack.isEmpty())
                    pop = stack.peek();
                
            }

            stack.push(a[i]);
        }

        while (!stack.isEmpty())
            System.out.println(stack.pop() + " :: -1");

    }

    public static void main(String[] args) {
        int a[] = {4, 5, 1, 7, 6, 2, 3};
        printNextGreaterElement(a);
    }
}
