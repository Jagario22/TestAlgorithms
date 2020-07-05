package com.nix.algorithmsTest;

import com.nix.algorithms.util.ArraysUtil;
import com.nix.algorithms.util.abstr.SortingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

public class TestingAlgorithm {
    final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static Long[][] testListOfAlgorithms(SortingAlgorithm[] sortingAlgorithms, int length, int numOfTesting) {
        Long[][] testings = new Long[numOfTesting][sortingAlgorithms.length + 1];
        long start, end;
        int[] num;
        int[] ints = new int[length];

        for (int i = 0; i < numOfTesting; i++) {
            ArraysUtil.fillArrayByRandomNums(ints);
            for (int j = 0; j < sortingAlgorithms.length; j++) {
                num = ints.clone();
                start = System.nanoTime();
                sortingAlgorithms[j].sort(num);
                end = System.nanoTime() - start;
                testings[i][j] = end;
            }
            num = ints.clone();
            start = System.nanoTime();
            Collections.sort(ArraysUtil.asList(num));
            end = System.nanoTime() - start;
            testings[i][sortingAlgorithms.length] = end;
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
