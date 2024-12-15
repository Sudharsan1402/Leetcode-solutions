class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] c: classes) maxHeap.add(new double[]{gain(c[0], c[1]), c[0], c[1]});
        while (extraStudents > 0) {
            double[] top = maxHeap.remove();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            double newGain = gain(pass, total);
            maxHeap.add(new double[]{newGain, pass, total});
            extraStudents--;
        }
        double ans = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            ans += (double) pass / total;
        }
        return ans / classes.length;
    }
    double gain(int pass, int total) {
        double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }
}