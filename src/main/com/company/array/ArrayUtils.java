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
}
