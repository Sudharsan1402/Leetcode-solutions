class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sums[0] = sum;
        
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            sums[i - k + 1] = sum;
        }
        
        int[] left = new int[sums.length];
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        int[] right = new int[sums.length];
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
            if (sums[i] >= sums[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        int[] ans = new int[]{-1, -1, -1};
        int maxSum = 0;
        for (int i = k; i < sums.length - k; i++) {
            int l = left[i - k];
            int r = right[i + k];
            int total = sums[l] + sums[i] + sums[r];
            
            if (ans[0] == -1 || total > maxSum) {
                maxSum = total;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        
        return ans;
    }
}