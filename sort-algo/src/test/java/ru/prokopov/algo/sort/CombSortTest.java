package ru.prokopov.algo.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CombSortTest {

    private int[] testArray1 = {5, 7, 2, 0, 1, 3, 9, 4, 10, 6, 8};
    private int[] testArrayRandom1000;
    {
        testArrayRandom1000 = new int[1_000];
        Random random = new Random();
        for (int i = 0; i < testArrayRandom1000.length - 1; i++) {
            testArrayRandom1000[i] = random.nextInt();
        }
    }

    private int[] exceptedSortArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] exceptedSortArrayRandom1000;
    {
        int[] temp = Arrays.copyOf(testArrayRandom1000, testArrayRandom1000.length);
        Arrays.parallelSort(temp);
        exceptedSortArrayRandom1000 = temp;
    }

    @Test
    public void testCombSort() {
        CombSort combSort = new CombSort();
        int[] result = combSort.sort(testArray1);
        assertArrayEquals(exceptedSortArray, result);
    }

    @Test
    public void testCombSortRandomArray() {
        CombSort combSort = new CombSort();
        int[] result = combSort.sort(testArrayRandom1000);
        assertArrayEquals(exceptedSortArrayRandom1000, result);
    }
}