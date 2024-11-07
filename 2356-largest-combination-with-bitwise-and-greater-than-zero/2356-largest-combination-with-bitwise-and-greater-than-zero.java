class Solution {
    public int largestCombination(int[] candidates) {
        int n=candidates.length;
        int maxFreq=0;
        for(int i=0;i<32;i++){
            int freq=0;
            for(int ele:candidates){
                if((ele&(1<<i))!=0){
                    freq++;
                }
            }
            maxFreq=Math.max(maxFreq,freq);
        }
        return maxFreq;
    }
}