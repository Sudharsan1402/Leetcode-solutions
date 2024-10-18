class Solution {
    public int countMaxOrSubsets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxOr = 0;
        for(int i: nums) {
            if(set.contains(i))
                continue;

            maxOr |= i;
            set.add(i);
        }

        return recursiveSol(nums, 0, 0, maxOr);
    }

    private int recursiveSol(int[] arr, int i, int currOr, int maxOr) {
        if(i == arr.length) {
            if(currOr == maxOr)
                return 1;

            return 0;
        }

        int include = recursiveSol(arr, i+1, currOr | arr[i], maxOr);
        int exclude = recursiveSol(arr, i+1, currOr, maxOr);

        return include + exclude;
    }
}