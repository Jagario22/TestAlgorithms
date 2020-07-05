package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;


public class SelectionSorting implements SortingAlgorithm {
    public void sort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            SortingAlgorithm.swap(array, left, minInd);
        }
    }
}
