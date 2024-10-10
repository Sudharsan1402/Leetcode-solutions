class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        while (right < n) {
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }
}