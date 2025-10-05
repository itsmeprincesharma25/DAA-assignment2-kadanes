package metrics;

/**
 * Simple class to track performance metrics
 * like comparisons and array accesses.
 */
public class PerformanceTracker {

    private int comparisons;
    private int arrayAccesses;

    public void incrementComparisons(int n) {
        comparisons += n;
    }

    public void incrementArrayAccess(int n) {
        arrayAccesses += n;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getArrayAccesses() {
        return arrayAccesses;
    }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
    }

    @Override
    public String toString() {
        return "Comparisons: " + comparisons + ", Array Accesses: " + arrayAccesses;
    }
}

