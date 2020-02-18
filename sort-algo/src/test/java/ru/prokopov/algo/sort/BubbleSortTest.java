package ru.prokopov.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private int[] testArray1 = {5, 7, 2, 0, 1, 3, 9, 4, 10, 6, 8};
    private int[] testArray2 = {0, 1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
    private int exceptedNumberIterationExitTestArray2 = 1;
    private int[] exceptedSortArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray1);
        assertArrayEquals(exceptedSortArray, result);
    }

    @Test
    public void testBubbleSortWithBreak() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(testArray2);
        int resultNumberIterationBreak = bubbleSort.getNumberIterationBreak();
        assertArrayEquals(exceptedSortArray, result);
        assertTrue(resultNumberIterationBreak > 0 && resultNumberIterationBreak < result.length );
        assertEquals(exceptedNumberIterationExitTestArray2, resultNumberIterationBreak);
    }
}