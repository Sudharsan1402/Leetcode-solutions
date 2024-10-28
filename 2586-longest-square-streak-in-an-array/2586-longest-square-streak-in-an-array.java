class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int [] arr = new int[100001];
        int maxi = 0;
        for(int i: nums)
        {
            int root = (int)Math.sqrt(i);
            if(root * root != i) arr[i] = 1; //no predecessor
            else arr[i] = arr[root] + 1; // extend streak from root
            maxi = Math.max(maxi, arr[i]);
        }
        if(maxi == 1) return -1;
        else return maxi;
    }
}