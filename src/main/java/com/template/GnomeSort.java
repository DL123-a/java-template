package com.template;

public class GnomeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {

        int index = 0;

        while (index < array.length) {

            if (index == 0) {
                index++;
            }

            if (array[index].compareTo(array[index - 1]) >= 0) {
                index++;
            } else {

                T temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;

                index--;
            }
        }
    }
}

