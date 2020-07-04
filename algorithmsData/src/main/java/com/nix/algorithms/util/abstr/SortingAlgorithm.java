package com.nix.algorithms.util.abstr;

public interface SortingAlgorithm {
    static void swap(int[] num, int i, int j) {
        int temp;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    void sort(int[] nums);
}
