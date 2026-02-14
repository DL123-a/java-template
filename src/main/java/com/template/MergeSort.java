package com.template;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right) {

        int n1 = middle - left + 1;
        int n2 = right - middle;

        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];

        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (((T) leftArray[i]).compareTo((T) rightArray[j]) <= 0) {
                array[k] = (T) leftArray[i];
                i++;
            } else {
                array[k] = (T) rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = (T) leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = (T) rightArray[j];
            j++;
            k++;
        }
    }
}