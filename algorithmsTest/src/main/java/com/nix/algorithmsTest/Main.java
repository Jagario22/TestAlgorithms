package com.nix.algorithmsTest;

import com.nix.algorithms.util.*;
import com.nix.algorithms.util.abstr.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);
    private final static int numOfTesting = 3;

    public static void main(String[] args) {

        int[] ints = new int[100000];
        ArraysUtil.fillArrayByRandomNums(ints);

        SortingAlgorithm[] sortingAlgorithms = {new BubbleSorting(), new InsertionSorting(), new MergeSorting(), new QuickSorting(),
                new SelectionSorting(), new ShellSorting(), new ShuttleSorting()};
        HashMap<String, Long> rating;

        Long[][] testings = TestingAlgorithm.testListOfAlgorithms(sortingAlgorithms, ints, numOfTesting);
        Long[] maxResults = ArraysUtil.getMaxByColumn(testings);
        rating = RatingOfAlgorithms.runtimeRate(sortingAlgorithms, maxResults);
        rating.forEach((name, runtime) -> logger.info(name + ": " + runtime));
        compareResults(sortingAlgorithms, ints);
    }


    private static void compareResults(SortingAlgorithm[] sortingAlgorithm, int[] nums) {
        long start, end;
        for (int i = 0; i < sortingAlgorithm.length; i++) {
            ArraysUtil.fillArrayByRandomNums(nums);
            start = System.nanoTime();
            sortingAlgorithm[i].sort(nums);
            end = System.nanoTime() - start;
            System.out.println(sortingAlgorithm[i].getClass().getName() + ": " + end);

            start = System.nanoTime();
            Collections.sort(ArraysUtil.asList(nums));
            end = System.nanoTime() - start;
            System.out.println("Collections sort method: " + end);
        }

    }
}
