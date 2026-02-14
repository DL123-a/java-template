package com.template;

public class RadixSort {

    public static void sort(Integer[] array){

        int max = getMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    private static int getMax(int[] array) {

        int max = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    private static void countSort(int[] array, int exp) {

        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {

            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}