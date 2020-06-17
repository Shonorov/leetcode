package com.company.array;

public class ArrayUtils {

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static void printTwoDimArray(int[][] arr) {
        for (int[] ints : arr) {
            printArray(ints);
        }
        System.out.println("");
    }

    public static void printCharArray(char[] arr) {
        System.out.print("[ ");
        for (char i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]");
    }

    public static void printTwoDimCharArray(char[][] arr) {
        for (char[] chars : arr) {
            printCharArray(chars);
        }
        System.out.println("");
    }
}
