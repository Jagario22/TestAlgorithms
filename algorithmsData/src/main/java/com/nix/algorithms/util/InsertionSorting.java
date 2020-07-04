package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class InsertionSorting implements SortingAlgorithm {
    public void sort (int[] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0 && num[j - 1] > num[j]; j--) {
                SortingAlgorithm.swap(num, j-1, j);
            }
        }
    }
}
