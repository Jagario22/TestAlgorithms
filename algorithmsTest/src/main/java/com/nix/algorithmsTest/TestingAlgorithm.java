package com.nix.algorithmsTest;

import com.nix.algorithms.util.ArraysUtil;
import com.nix.algorithms.util.abstr.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class TestingAlgorithm {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static Long[][] testListOfAlgorithms(SortingAlgorithm[] sortingAlgorithms, int[] ints, int numOfTesting) {
        Long[][] testings = new Long[numOfTesting][sortingAlgorithms.length];

        for (int i = 0; i < numOfTesting; i++) {
            for (int j = 0; j < sortingAlgorithms.length; j++) {
                ArraysUtil.fillArrayByRandomNums(ints);
                long start = System.nanoTime();
                sortingAlgorithms[j].sort(ints);
                long end = System.nanoTime() - start;
                testings[i][j] = end;

            }
            logger.debug("Num of testing №" + (i + 1) + "  " + Arrays.deepToString(testings));
        }
        return testings;
    }

    public static Long[] testAlgorithm(SortingAlgorithm sortingAlgorithm, int[] ints, int numOfTesting) {
        Long[] testings = new Long[numOfTesting];
        long start, end;
        for (int i = 0; i < numOfTesting; i++) {
            ArraysUtil.fillArrayByRandomNums(ints);
            start = System.nanoTime();
            sortingAlgorithm.sort(ints);
            end = System.nanoTime() - start;
            testings[i] = end;
            logger.debug("Num of testing №" + (i + 1) + "  " + Arrays.toString(testings));

        }
        return testings;
    }
}
