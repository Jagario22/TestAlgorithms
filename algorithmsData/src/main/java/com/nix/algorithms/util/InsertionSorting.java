package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class InsertionSorting implements SortingAlgorithm {
    public void sort (int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }
}
