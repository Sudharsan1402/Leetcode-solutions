class Solution {
    public int findLengthOfShortestSubarray(int[] a) {
        int n = a.length;

        int i = 0;
        while(i + 1 < n && a[i] <= a[i + 1]) ++i;

        int j = n - 1;
        while(j - 1 >= 0 && a[j] >= a[j - 1]) j--;

        int ans = n - Math.max(i + 1, n - j);
        if(j == 0) return 0;

        int l = 0;
        int r = j;
        
        while(l <= i){
            while(r < n && a[r] < a[l]) r++;
            if(r == n) break;
             ans = Math.min(ans, r - 1 - l);
            ++l;
        }
        return ans;


    }
}