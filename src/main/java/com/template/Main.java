package com.template;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== DATOS DESORDENADOS ===");
        System.out.println("size,bubble,quick,merge,radix");

        Random random = new Random();

        for (int size = 10; size <= 3000; size += 500) {

            Integer[] originalArray = new Integer[size];

            for (int i = 0; i < size; i++) {
                originalArray[i] = random.nextInt(10000);
            }

            ejecutarPruebas(originalArray, size);
        }

        System.out.println("\n=== DATOS YA ORDENADOS ===");
        System.out.println("size,bubble,quick,merge,radix");

        for (int size = 10; size <= 3000; size += 500) {

            Integer[] originalArray = new Integer[size];

            for (int i = 0; i < size; i++) {
                originalArray[i] = random.nextInt(10000);
            }

            // Primero ordenamos para crear mejor caso
            MergeSort.sort(originalArray);

            ejecutarPruebas(originalArray, size);
        }
    }

    private static void ejecutarPruebas(Integer[] originalArray, int size) {

        // Bubble
        Integer[] bubbleArray = originalArray.clone();
        long start = System.nanoTime();
        BubbleSort.sort(bubbleArray);
        long bubbleTime = System.nanoTime() - start;

        // Quick
        Integer[] quickArray = originalArray.clone();
        start = System.nanoTime();
        QuickSort.sort(quickArray);
        long quickTime = System.nanoTime() - start;

        // Merge
        Integer[] mergeArray = originalArray.clone();
        start = System.nanoTime();
        MergeSort.sort(mergeArray);
        long mergeTime = System.nanoTime() - start;

        // Radix
        Integer[] radixArray = originalArray.clone();
        start = System.nanoTime();
        RadixSort.sort(radixArray);
        long radixTime = System.nanoTime() - start;

        System.out.println(size + "," + bubbleTime + "," + quickTime + "," + mergeTime + "," + radixTime);
    }
}
