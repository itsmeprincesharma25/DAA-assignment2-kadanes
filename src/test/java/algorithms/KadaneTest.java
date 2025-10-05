package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Kadane's Algorithm
 */
public class KadaneTest {

    @Test
    void testBasicArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane kadane = new Kadane(tracker);

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Kadane.Result result = kadane.findMaxSubarray(arr);

        assertEquals(6, result.maxSum); // expected sum: 6
        assertEquals(3, result.startIndex);
        assertEquals(6, result.endIndex);
    }

    @Test
    void testAllNegative() {
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane kadane = new Kadane(tracker);

        int[] arr = {-5, -2, -3, -1};
        Kadane.Result result = kadane.findMaxSubarray(arr);

        assertEquals(-1, result.maxSum);
    }

    @Test
    void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane kadane = new Kadane(tracker);

        int[] arr = {};
        Kadane.Result result = kadane.findMaxSubarray(arr);

        assertEquals(0, result.maxSum);
        assertEquals(-1, result.startIndex);
        assertEquals(-1, result.endIndex);
    }
}
