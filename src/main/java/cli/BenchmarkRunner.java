package cli;

import algorithms.Kadane;
import algorithms.Kadane.Result;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * BenchmarkRunner
 * Measures performance of Kadane's Algorithm for various input sizes
 * and saves results into a CSV file for plotting.
 */
public class BenchmarkRunner {

    public static void main(String[] args) {
        PerformanceTracker tracker = new PerformanceTracker();
        Kadane kadane = new Kadane(tracker);
        Random rand = new Random();

        // Array sizes to test
        int[] sizes = {100, 1000, 10000, 50000, 100000};

        // Output CSV file path
        String outputPath = "docs/performance-plots/benchmark_results.csv";

        try (FileWriter writer = new FileWriter(outputPath)) {
            // CSV header
            writer.write("Input Size (n),Execution Time (ns),Comparisons,Array Accesses\n");

            for (int n : sizes) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(101) - 50; // random between -50 and 50
                }

                tracker.reset();

                long start = System.nanoTime();
                Result result = kadane.findMaxSubarray(arr);
                long end = System.nanoTime();

                long timeTaken = end - start;

                // Write to CSV
                writer.write(n + "," + timeTaken + "," + tracker.getComparisons() + "," + tracker.getArrayAccesses() + "\n");

                System.out.println("n = " + n + " → Time: " + timeTaken + " ns | " + result);
            }

            System.out.println("\n✅ Benchmark complete. Results saved to: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
