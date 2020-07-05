package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class ShuttleSorting implements SortingAlgorithm {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                SortingAlgorithm.swap(array, i, i - 1);
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        SortingAlgorithm.swap(array, z, z - 1);
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
