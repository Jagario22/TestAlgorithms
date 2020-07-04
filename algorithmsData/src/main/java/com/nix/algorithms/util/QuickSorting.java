package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class QuickSorting implements SortingAlgorithm {
    public void sort(int[] num) {
        quickSort(num, 0, num.length - 1);
    }

    private static void quickSort(int[] num, int left, int right) {
        if (left < right)
        {
            int pivot = partition(num, left, right);

            quickSort(num, left, pivot - 1);
            quickSort(num, pivot + 1, right);
        }
    }

    private static int partition(int[] num, int left, int right) {
        int pivot = num[right];    // pivot
        int i = (left - 1);
        int temp;
        for (int j = left; j <= right- 1; j++)
        {
            if (num[j] <= pivot)
            {
                i++;
                SortingAlgorithm.swap(num, i, j);
            }
        }
        SortingAlgorithm.swap(num, right, i+1);

        return (i + 1);
    }
}
