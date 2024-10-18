class Solution {
    private void backTrack(int[] nums, int index, int currentOR, int maxOR, int[] count){
        if (currentOR == maxOR) {
            count[0]++;
        }
        for (int i = index; i < nums.length; i++){
            backTrack(nums, i + 1, currentOR | nums[i], maxOR, count);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;

        for (int num : nums){
            maxOR |= num;
        }

        int[] count = new int[1];
        backTrack(nums, 0, 0, maxOR, count);

        return count[0];
    }
}