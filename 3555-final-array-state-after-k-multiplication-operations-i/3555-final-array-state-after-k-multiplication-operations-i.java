class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
         while (k-- > 0) {
            int mini = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[mini]) {
                    mini = i;
                }
            }
            nums[mini] *= multiplier;
        }
        return nums;
    }
}