package cli;

import algorithms.Kadane;
import algorithms.Kadane.Result;
import metrics.PerformanceTracker;

import java.util.Random;
import java.util.Scanner;

/**
 * Command-line interface for testing Kadane's Algorithm
 * Allows user to test on random arrays of any size.
 */
public class BenchmarkRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane kadane = new Kadane(tracker);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        Random rand = new Random();

        // Fill array with random values between -50 and 50
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(101) - 50;
        }

        // Run Kadane's Algorithm
        tracker.reset();
        long startTime = System.nanoTime();
        Result result = kadane.findMaxSubarray(arr);
        long endTime = System.nanoTime();

        // Display results
        System.out.println("\n" + result);
        System.out.println("Time Taken (ns): " + (endTime - startTime));
        System.out.println(tracker);
    }
}
