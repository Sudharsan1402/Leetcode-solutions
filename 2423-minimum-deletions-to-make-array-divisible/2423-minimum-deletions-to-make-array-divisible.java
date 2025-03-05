class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int g = numsDivide[0];
        for(int num : numsDivide){
            g = gcd(g,num);
            if(g == 1) break;
        }
        for(int i=0;i<nums.length;i++){
            if(g%nums[i] == 0){
                return i;
            }
        }
        return -1;
        
    }

    public int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}