class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int i =0;
        int j =i+1;
        int n = nums.length;
        int results[]=new int[n - k + 1];
        for(i=0;i<(n - k + 1);i++){
            int start = i;
            int end = i+k-1;
            if (consecutive(nums,start,end)){
                results[i]=nums[end];

            }
            else{
                results[i]=-1;
            }
        }
        return results;
    }
    private boolean consecutive(int nums[],int l,int r){
        for(int i= l;i< r;i++){
            
                    if(nums[i]+1!=nums[i+1]){
                        return false;
                    }
            }
             return true;
            
    }
        
}