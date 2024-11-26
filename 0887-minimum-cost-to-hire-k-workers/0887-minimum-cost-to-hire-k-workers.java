class Solution {
    class Worker {
        int quality;
        double wagePerQuality;

        public Worker(int quality, double wagePerQuality) {
            this.quality = quality;
            this.wagePerQuality = wagePerQuality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < wage.length; i++) {
            workers.add(new Worker(quality[i], (double) wage[i] / quality[i]));
        }
        workers.sort((a, b) -> Double.compare(a.wagePerQuality, b.wagePerQuality));
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (Worker w : workers) {
            totalQuality += w.quality;
            maxHeap.add(w.quality);

            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                double currCost = totalQuality * w.wagePerQuality;
                minCost = Math.min(minCost, currCost);
            }
        }

        return minCost;
    }
}
