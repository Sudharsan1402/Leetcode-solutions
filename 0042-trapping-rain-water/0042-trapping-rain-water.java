class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftmax = height[left], rightmax = height[right];
        int wtrtrapped = 0;
        while(left<right){
            if(leftmax<=rightmax){
                wtrtrapped += leftmax-height[left++];
                leftmax = Math.max(leftmax, height[left]);

            }
            else{
                wtrtrapped += rightmax-height[right--];
                rightmax = Math.max(rightmax, height[right]);
            }
        }
        return wtrtrapped;
        
    }
}