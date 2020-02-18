package ru.prokopov.algo.sort;

public class BubbleSort implements Sort{

    private int numberIterationBreak = 0;

    @Override
    public int[] sort(int[] array) {
        int endSort;
        for (int i = 0; i <= array.length - 1; i++) {
            endSort = 0;
            int temp;
            for(int j = 0; j < array.length - 1; j++ ) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    endSort = 1;
                }
            }
            if (endSort == 0) {
                numberIterationBreak = i;
                break;
            }
        }
        return array;
    }

    public int getNumberIterationBreak() {
        return numberIterationBreak;
    }
}
