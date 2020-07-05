package com.nix.algorithmsTest;

import com.nix.algorithms.util.ArraysUtil;
import com.nix.algorithms.util.abstr.SortingAlgorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RatingOfAlgorithms {
    private static int numOfAlgorithms;

    static HashMap<String, Long> runtimeRate(SortingAlgorithm[] sortingAlgorithm, Long[] runtime) {
        numOfAlgorithms = sortingAlgorithm.length;
        HashMap<String, Long> rating = new HashMap<>();
        String[] algorithmNames = new String[numOfAlgorithms];
        ArraysUtil.fillArrayByAlgorithmNames(algorithmNames, sortingAlgorithm);

        for (int i = 0; i < numOfAlgorithms; i++) {
            rating.put(algorithmNames[i], runtime[i]);
        }
        rating.put("Collections.sort()", runtime[runtime.length - 1]);
        rating = rating.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return rating;
    }
}
