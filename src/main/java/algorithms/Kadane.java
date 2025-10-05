package algorithms;

/**
 * Kadane's Algorithm
 * Finds the maximum sum of a contiguous subarray in linear time O(n).
 * Also tracks the start and end indices of the subarray.
 */
public class Kadane {

    // Reference to performance tracker for counting operations
    private metrics.PerformanceTracker tracker;

    public Kadane(metrics.PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Finds maximum subarray sum using Kadane's Algorithm
     * @param arr input array of integers
     * @return result object containing maxSum, startIndex, endIndex
     */
    public Result findMaxSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new Result(0, -1, -1);
        }

        int maxSoFar = arr[0];
        int currentMax = arr[0];
        int start = 0, end = 0, tempStart = 0;

        tracker.incrementArrayAccess(2);

        for (int i = 1; i < arr.length; i++) {
            tracker.incrementArrayAccess(1); // accessing arr[i]
            tracker.incrementComparisons(1); // comparison in max()

            // Either start new subarray from arr[i] or extend the current one
            if (arr[i] > currentMax + arr[i]) {
                currentMax = arr[i];
                tempStart = i; // new start
            } else {
                currentMax = currentMax + arr[i];
            }

            // Update global max if needed
            tracker.incrementComparisons(1);
            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = tempStart;
                end = i;
            }
        }

        return new Result(maxSoFar, start, end);
    }

    // Helper class to store result details
    public static class Result {
        public int maxSum;
        public int startIndex;
        public int endIndex;

        public Result(int maxSum, int startIndex, int endIndex) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return "Max Sum: " + maxSum + " | Start: " + startIndex + " | End: " + endIndex;
        }
    }
}
