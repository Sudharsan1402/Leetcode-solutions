class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            pq.add(i);
        }
        while(k-- > 0){
            int max = pq.poll();
            ans += max;
            pq.add((int) Math.ceil(max/3.0));
        }
        return ans;
       
        
    }
}