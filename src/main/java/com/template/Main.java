package com.template;

import java.util.Random;

public class Main {

    private static final int ARRAY_SIZE = 10000;

    public static void main(String[] args) {

        System.out.println("Iniciando programa...");
        System.out.println("Version de Java: " + System.getProperty("java.version"));

        Random random = new Random();

        // -------- BubbleSort ----------
        Integer[] bubbleArray = new Integer[ARRAY_SIZE];

        for(int i = 0; i < bubbleArray.length; i++){
            bubbleArray[i] = random.nextInt(1000);
        }

        BubbleSort.sort(bubbleArray);
        System.out.println("BubbleSort terminado");


        // -------- QuickSort ----------
        Integer[] quickArray = bubbleArray.clone();
        QuickSort.sort(quickArray);
        System.out.println("QuickSort terminado");


        // -------- MergeSort ----------
        Integer[] mergeArray = bubbleArray.clone();
        MergeSort.sort(mergeArray);
        System.out.println("MergeSort terminado");


        // -------- RadixSort ----------
        int[] radixArray = new int[ARRAY_SIZE];

        for(int i = 0; i < radixArray.length; i++){
            radixArray[i] = random.nextInt(1000);
        }

        RadixSort.sort(radixArray);
        System.out.println("RadixSort terminado");

        System.out.println("Programa finalizado.");
    }
}
