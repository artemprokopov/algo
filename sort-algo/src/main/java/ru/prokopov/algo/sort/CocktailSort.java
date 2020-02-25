package ru.prokopov.algo.sort;

public class CocktailSort implements Sort {

    private int numberIterationBreak = 0;

    @Override
    public int[] sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean continueSort = true;
        int temp;
        while (continueSort) {
            continueSort = false;
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    continueSort = true;
                }
                numberIterationBreak++;
            }
            if (!continueSort) {
                break;
            }
            right--;
            continueSort = false;
            for (int j = right; j > left; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    continueSort = true;
                }
                numberIterationBreak++;
            }
            left++;
        }
        return array;
    }

    public int getNumberIterationBreak() {
        return numberIterationBreak;
    }
}
