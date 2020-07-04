package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class ShuttleSorting implements SortingAlgorithm {
    public void sort(int[] num) {
        int temp;
        for (int i = 1; i < num.length; i++) {
            if (num[i] < num[i - 1]) {
                SortingAlgorithm.swap(num, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (num[z] < num[z - 1]) {
                        SortingAlgorithm.swap(num, z, z-1);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
