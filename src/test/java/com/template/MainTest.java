package com.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Main class.
 * These tests verify the correctness of the various operations
 * performed by the Main class.
 */
public class MainTest {
    @Test
    @DisplayName("Test that main method runs without exceptions")
    public void testMainRuns() {
        // This test verifies that the main method can be executed
        // without throwing exceptions. In a real scenario, you might
        // want to refactor Main to be more testable.
        assertDoesNotThrow(() -> {
            // We can't easily test main() directly without refactoring,
            // but we can test that the class loads correctly
            Main main = new Main();
            assertNotNull(main);
        });
    }

    @Test
    @DisplayName("BubbleSort ordena correctamente")
    void testBubbleSort() {
        Integer[] array = {5, 3, 8, 1, 2};
        BubbleSort.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 3, 5, 8}, array);
    }

    @Test
    @DisplayName("GnomeSort ordena correctamente")
    void testGnomeSort() {
        Integer[] array = {9, 4, 6, 2, 7};
        GnomeSort.sort(array);
        assertArrayEquals(new Integer[]{2, 4, 6, 7, 9}, array);
    }

    @Test
    @DisplayName("MergeSort ordena correctamente")
    void testMergeSort() {
        Integer[] array = {10, 3, 5, 1, 8};
        MergeSort.sort(array);
        assertArrayEquals(new Integer[]{1, 3, 5, 8, 10}, array);
    }

    @Test
    @DisplayName("QuickSort ordena correctamente")
    void testQuickSort() {
        Integer[] array = {7, 2, 9, 4, 1};
        QuickSort.sort(array);
        assertArrayEquals(new Integer[]{1, 2, 4, 7, 9}, array);
    }

    @Test
    @DisplayName("RadixSort ordena correctamente")
    void testRadixSort() {
        Integer[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort.sort(array);
        assertArrayEquals(new Integer[]{2, 24, 45, 66, 75, 90, 170, 802}, array);
    }
}

