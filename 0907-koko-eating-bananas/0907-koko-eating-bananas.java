class Solution {
    private long hoursToEat(int[] piles, int k){
        long h = 0;
        for(int p :piles){
            int div = p/k;
            if(p%k!=0)h+=1;
            h+=div;
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        for(int p:piles)if(p>max)max = p;
        int min = 1;
        int res = -1;
        while(min<=max){
            int m = min + (max-min)/2;
            long hoursTaken = hoursToEat(piles,m);
            if(hoursTaken<=h){
                res = m;
                max = m-1;
            }else min = m+1;
        }
        return res;
    }
}