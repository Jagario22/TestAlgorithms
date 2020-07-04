import com.nix.algorithms.util.ArraysUtil;
import com.nix.algorithms.util.QuickSorting;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {
    private final QuickSorting quickSorting = new QuickSorting();

    @Test
    void run() {
        int[] arr = {100000};
        ArraysUtil.fillArrayByRandomNums(arr);

        List<Integer> list = new ArrayList<>();
        for (int value : arr)
            list.add(value);

        quickSorting.sort(arr);
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(list.get(i), arr[i]);
        }

    }

}
