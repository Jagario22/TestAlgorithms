package com.nix.algorithmsTest;

import com.nix.algorithms.util.ArraysUtil;
import com.nix.algorithms.util.abstr.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

public class RuntimeTestingAlgorithm {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static Long[][] test(SortingAlgorithm[] sortingAlgorithms, int length, int numOfTesting) {
        Long[][] testings = new Long[numOfTesting][sortingAlgorithms.length + 1];
        long start, end;
        int[] num;
        int[] ints = new int[length];

        logger.debug("Testing is started...");
        for (int i = 0; i < numOfTesting; i++) {
            ArraysUtil.fillArrayByRandomNums(ints);
            for (int j = 0; j < sortingAlgorithms.length; j++) {
                num = ints.clone();
                end = test(sortingAlgorithms[j], num);
                testings[i][j] = end;
            }
            num = ints.clone();
            start = System.nanoTime();
            Collections.sort(ArraysUtil.asList(num));
            end = System.nanoTime() - start;

            testings[i][sortingAlgorithms.length] = end;
            logger.debug("Num of testing №" + (i + 1) + "  " + Arrays.deepToString(testings));
        }
        logger.debug("Testing completed...");
        return testings;
    }

    public static Long[] test(SortingAlgorithm sortingAlgorithm, int[] ints, int numOfTesting) {
        Long[] testings = new Long[numOfTesting];
        long end;
        for (int i = 0; i < numOfTesting; i++) {
            ArraysUtil.fillArrayByRandomNums(ints);
            end = test(sortingAlgorithm, ints);
            testings[i] = end;
            logger.debug("Num of testing №" + (i + 1) + "  " + Arrays.toString(testings));

        }
        return testings;
    }

    private static long test(SortingAlgorithm sortingAlgorithm, int[] num) {
        long start, end;
        start = System.nanoTime();
        sortingAlgorithm.sort(num);
        end = System.nanoTime() - start;
        return end;
    }
}