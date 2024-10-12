class Solution {

    public int minGroups(int[][] intervals) {
        // Use a TreeMap to store the points and their counts
        TreeMap<Integer, Integer> pointToCount = new TreeMap<>();

        // Mark the starting and ending points in the TreeMap
        for (int[] interval : intervals) {
            pointToCount.put(
                interval[0],
                pointToCount.getOrDefault(interval[0], 0) + 1
            );
            pointToCount.put(
                interval[1] + 1,
                pointToCount.getOrDefault(interval[1] + 1, 0) - 1
            );
        }

        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;

        // Iterate over the entries of the TreeMap in ascending order of keys
        for (Map.Entry<Integer, Integer> entry : pointToCount.entrySet()) {
            concurrentIntervals += entry.getValue(); // Update currently active intervals
            maxConcurrentIntervals = Math.max(
                maxConcurrentIntervals,
                concurrentIntervals
            ); // Update max intervals
        }

        return maxConcurrentIntervals;
    }
}