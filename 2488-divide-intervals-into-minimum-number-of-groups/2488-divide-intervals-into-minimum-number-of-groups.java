class Solution {
    public int minGroups(int[][] intervals) {
       int min=Integer.MAX_VALUE;
       int max=Integer.MIN_VALUE;
       int n=intervals.length;
       for(int[] interval:intervals){
          max=Math.max(max,interval[1]);
          min=Math.min(min,interval[0]);
       }
       int fre[]=new int[max+2];
       for(int[] interval:intervals){
          fre[interval[0]]++;
          fre[interval[1]+1]--;

       }
       // prefix sum 
       int sum=0;
       int res=0;
       for(int i=min;i<max+2;i++){
           sum+=fre[i];
           res=Math.max(res,sum);
       }
      
       return res;
    }
}