class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans=Integer.MIN_VALUE;
        int m=values[0];

        for(int j=1;j<values.length;j++){
            ans = Math.max(ans, values[j]-j+m);
            m = Math.max(m, values[j]+j);
        }

        return ans;
    }
}