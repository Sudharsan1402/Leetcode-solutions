class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] setBitsCount = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 0) {
                setBitsCount[i] += (num & 1);
                num >>= 1;
            }
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        for (int i = 0; i < n;) {
            int start = i;
            int setBits = setBitsCount[i];
            while (i < n && setBitsCount[i] == setBits) {
                i++;
            }
            int[] partition = Arrays.copyOfRange(nums, start, i);
            Arrays.sort(partition);
            for (int j = 0; j < partition.length; j++) {
                if (partition[j] != sortedNums[start + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}