class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        // Priority queue to store (value, list index, element index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int maxVal = Integer.MIN_VALUE, rangeStart = 0, rangeEnd =
            Integer.MAX_VALUE;

        // Insert the first element from each list into the min-heap
        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new int[] { nums.get(i).get(0), i, 0 });
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        // Continue until we can't proceed further
        while (pq.size() == nums.size()) {
            int[] data = pq.poll();
            int minVal = data[0], row = data[1], col = data[2];

            // Update the smallest range
            if (maxVal - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = maxVal;
            }

            // If possible, add the next element from the same row to the heap
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[] { nextVal, row, col + 1 });
                maxVal = Math.max(maxVal, nextVal);
            }
        }

        return new int[] { rangeStart, rangeEnd };
    }
}