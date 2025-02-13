package ru.prokopov.algo.sort;

public class CombSort implements Sort{

    private int numberIterationBreak = 0;

    @Override
    public int[] sort(int[] array) {
        double k = 1.2473309;
        int step = array.length - 1;
        int temp = 0;
        while (step >= 1) {
            for (int i = 0; i  < array.length - step ; i++) {
                if (array[i] > array[i + step]) {
                    temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                }
                numberIterationBreak++;
            }
            step /= k;
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        numberIterationBreak += bubbleSort.getNumberIterationBreak();
        return array;
    }

    public int getNumberIterationBreak() {
        return numberIterationBreak;
    }
}
