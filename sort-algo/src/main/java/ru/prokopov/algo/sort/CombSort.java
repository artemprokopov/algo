package ru.prokopov.algo.sort;

public class CombSort implements Sort{

    private int numberIterationBreak = 0;

    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        double k = 1.2473309;
        int step = array.length - 1;
        int temp = 0;
        while (step >= 1) {
            for (int i = 0; i + step < array.length ; i++) {
                if (array[i] > array[i + step]) {
                    temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                }
            }
            step /= k;
        }
        boolean endSort = true;
        for (int f = 0; f < array.length ; f++) {
            endSort = false;
            for (int j = 0; j < array.length - f - 1 ; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    endSort = true;
                }
            }
            if (!endSort) {
                break;
            }
        }
        return array;
    }

    public int getNumberIterationBreak() {
        return numberIterationBreak;
    }
}
