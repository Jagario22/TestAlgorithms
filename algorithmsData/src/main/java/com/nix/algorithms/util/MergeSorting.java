package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

public class MergeSorting implements SortingAlgorithm {
    public void sort(int[] num) {
       mergeSort(num, 0, num.length - 1);
    }


    private static void mergeSort(int[] num, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;

            mergeSort(num, left, mid);
            mergeSort(num, mid + 1, right);

            merge(num, left, right, mid);
        }
    }
    private static void merge(int[] num, int left, int right, int mid) {
        int i, j, k;
        int[] temp = new int[right - left + 1];
        i = left;
        k = 0;
        j = mid + 1;

        while (i <= mid && j <= right) {
            if (num[i] < num[j]) {
                temp[k] = num[i];
                k++;
                i++;
            } else {
                temp[k] = num[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = num[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = num[j];
            k++;
            j++;
        }

        for (i = left; i <= right; i++) {
            num[i] = temp[i - left];
        }
    }
}
