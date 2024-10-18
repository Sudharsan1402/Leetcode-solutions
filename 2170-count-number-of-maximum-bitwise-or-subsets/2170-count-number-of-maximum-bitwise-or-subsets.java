class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int [] dp = new int[1 << 17];
        dp[0] = 1;
        for(int num: nums){
            for(int i = max;i>=0;i--){
                dp[i|num] += dp[i];
            }
            max |= num;
        }
        return dp[max];
        
    }
}