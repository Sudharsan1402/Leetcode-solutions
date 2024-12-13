class Solution {

    public long findScore(int[] nums) {
        
        long ans = 0;
        int n = nums.length;
        int [][] arr = new int[n][2];
        boolean [] marked = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] - arr2[0]);

        for(int i=0;i<n;i++){
            int index = arr[i][1];
            if(!marked[index]){
                ans += arr[i][0];
                marked[index] = true;
                
                if(index-1 >= 0){
                    marked[index-1] = true;
                }
                if(index+1 < n){
                    marked[index+1] = true;
                }
            }
        }

        return ans;




    }
}