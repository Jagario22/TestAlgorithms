package com.nix.algorithms.util;

import com.nix.algorithms.util.abstr.SortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class ArraysUtil {
    public static void fillArrayByRandomNums(int[] arr) {
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = (int) Math.floor(Math.random() * 100000);
            arr[i] = index;
        }
    }

    public static void fillArrayByAlgorithmNames(String[] arr, SortingAlgorithm[] sortingAlgorithms) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = sortingAlgorithms[i].getClass().getName();
    }

    public static Long[] getMaxByColumn(Long[][] arr) {
        Long[] result = new Long[arr[0].length];
        Long max;


        for (int i = 0; i < arr[0].length; i++) {
            max = 0L;
            for (Long[] longs : arr) {
                if (longs[i] > max)
                    max = longs[i];
            }
            result[i] = max;
        }
        return result;
    }

    public static List<Integer> asList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            list.add(value);
        }
        return list;
    }
}
