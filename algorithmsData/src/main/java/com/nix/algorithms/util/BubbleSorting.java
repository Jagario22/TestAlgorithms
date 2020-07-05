package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class BubbleSorting implements SortingAlgorithm {
    public void sort(int[] num) {

        boolean swapped = true;
        int n = num.length;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (num[i] > num[i + 1]) {
                    SortingAlgorithm.swap(num, i, i+1);
                    swapped = true;
                }
            }
            n--;
        }
    }
}
