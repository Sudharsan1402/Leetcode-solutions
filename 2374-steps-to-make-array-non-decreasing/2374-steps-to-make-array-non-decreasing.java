class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] st = new int[n + 1];  
        int[] ans = new int[n];      
        int top = -1;               
        int maxSteps = 0;           
        st[++top] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[st[top]]) {
                ans[i] = 1;
            } else {
                int max = 0;
                while (top != -1 && nums[i] >= nums[st[top]]) {
                    max = Math.max(max, ans[st[top--]]);
                }
                if (top != -1) {
                    ans[i] = max + 1; 
                }
            }

            maxSteps = Math.max(maxSteps, ans[i]);
            st[++top] = i;
        }

        return maxSteps;
    }
}