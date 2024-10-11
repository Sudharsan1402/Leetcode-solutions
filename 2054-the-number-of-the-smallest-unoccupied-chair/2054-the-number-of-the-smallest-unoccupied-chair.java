class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<Integer> sorted = new ArrayList<>();
        for(int i=0; i<times.length; i++) sorted.add(i);
        Collections.sort(sorted, (a,b) -> {
            return times[a][0]-times[b][0];
        });
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<int[]> map = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max=0;
        for(int i=0; i<times.length; i++) {
            int idx = sorted.get(i);
            int start = times[idx][0], end = times[idx][1];
            while(!map.isEmpty() && map.peek()[0] <= start) {
                pq.add(map.remove()[1]);
            }
            int next = pq.isEmpty()? max++ : pq.remove();
            if(idx == targetFriend) return next;
            
            map.add(new int[]{end, next});
        }
        
        return -1;
    }
}