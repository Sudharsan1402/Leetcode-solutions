class Solution {
    public int longestSquareStreak(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n:nums){
            set.add(n);
        }

        Arrays.sort(nums);

        int maxLen = 0;
        for(int i = 0;i<nums.length;i++){

            int currLen = 0;
            int curr = nums[i];

            while(set.contains(curr)){
                set.remove(curr);
                currLen++;
                curr = curr * curr;
            }

            maxLen = Math.max(maxLen,currLen);
        }

        return maxLen > 1 ? maxLen:-1;
    }
}