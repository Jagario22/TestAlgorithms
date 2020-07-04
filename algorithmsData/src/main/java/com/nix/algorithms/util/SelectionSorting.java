package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class SelectionSorting implements SortingAlgorithm {
    public void sort(int[] num) {
        int min, temp;
        for (int i = 0; i < num.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[min])
                    min = j;
            }
            SortingAlgorithm.swap(num, i,min);
        }
    }
}
