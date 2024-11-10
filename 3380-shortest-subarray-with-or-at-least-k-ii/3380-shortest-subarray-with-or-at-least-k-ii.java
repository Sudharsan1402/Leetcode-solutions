class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int[] pow = new int[32];
        int temp = 1;
        int n = nums.length;
        for(int i=0; i<32; i++){
            pow[i] = temp;
            temp *= 2;
        }

        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;
        while(j<n){
            if(nums[j]>=k){
                return 1;
            }
            rec(nums[j], bits);

            while(met(bits, pow)>=k){
                res = Math.min(res, (j-i+1));
                rec1(nums[i], bits);
                i++;
            }
            j++;
        }

        return res==Integer.MAX_VALUE?-1:res;
    }

    static void rec1(int num, int[] bits){
        int ind = 0;

        while(num>0){
            bits[ind++] -= num%2;
            num /= 2;
        }
    }

    static int met(int[] bits, int[] pow){
        int num = 0;

        for(int i=0; i<32; i++){
            if(bits[i]>0){
                num += pow[i];
            }
        }

        return num;
    }

    static void rec(int num, int[] bits){
        int ind = 0;

        while(num>0){
            bits[ind++] += num%2;
            num /= 2;
        }
    }
}