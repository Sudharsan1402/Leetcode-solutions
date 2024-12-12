class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift:gifts){
            heap.add(gift);
        }
        for(int i=0;i<k;i++){
            int max = heap.poll();
            heap.offer((int) Math.sqrt(max));
        }

        long sum = 0;
        while(!heap.isEmpty()){
            sum += heap.poll();
        }
        return sum;
        
    }
}