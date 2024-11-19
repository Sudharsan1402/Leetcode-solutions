class Solution {
    public long maximumSubarraySum(int[] nums, int k) {        
        int max = 0;
        for(int n : nums) max = Math.max(max, n);

        int[] contains = new int[max + 1];
        long sum = 0, ans = 0;
        int duplicates = 0;  

        for(int r = 0, l = 0; r < nums.length; ++r) {
            sum += nums[r];
            if(contains[nums[r]] > 0) ++duplicates;
            ++contains[nums[r]];

            if(r >= k - 1) {
                if(duplicates == 0) ans = Math.max(sum, ans);
                sum -= nums[l];
                if(contains[nums[l]] > 1) --duplicates;
                --contains[nums[l++]];
            }
        }
        return ans;
    }
}