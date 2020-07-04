package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class ShellSorting implements SortingAlgorithm {

    public void sort(int[] num) {
        int gap = num.length / 2;
        int temp;
        while (gap >= 1) {
            for (int right = 0; right < num.length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (num[c] > num[c + gap]) {
                        SortingAlgorithm.swap(num, c, c + gap);
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
