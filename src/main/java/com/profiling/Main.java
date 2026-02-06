package com.profiling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Main class with profilable workload for Java Flight Recorder analysis.
 * This class performs various CPU-intensive operations that are useful
 * for profiling demonstrations.
 */
public class Main {
    private static final int ARRAY_SIZE = 100000;
    private static final int ITERATIONS = 1000;
    
    public static void main(String[] args) {
        System.out.println("Starting profiling demo application...");
        System.out.println("JDK Version: " + System.getProperty("java.version"));
        
        // Perform various operations that create interesting profiling data
        performBubbleSort();
        
        System.out.println("Application completed successfully.");
    }
    
    /**
     * Performs bubble sort on a random array - O(n²) complexity
     */
    private static void performBubbleSort() {
        System.out.println("Performing bubble sort...");
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE / 10]; // Smaller array for bubble sort
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        
        // Bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
        
        System.out.println("Bubble sort completed.");
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp; 
    }

}