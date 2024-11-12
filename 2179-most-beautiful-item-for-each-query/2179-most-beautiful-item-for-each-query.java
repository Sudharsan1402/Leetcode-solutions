class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,Comparator.comparingDouble(o->o[0]));
        int max=Integer.MIN_VALUE;
        for(int i=0;i<items.length;i++){
          max=Math.max(max,items[i][1]);
          items[i][1]=max;
        }
       
        int ans[]=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int target=queries[i];
             int left=0;
             int right=items.length-1;
            int value=0;
        while(right>=left){
            int mid=left+(right-left)/2;
            if(items[mid][0]<=target){
                value=items[mid][1];
                left=mid+1;
            }
           
            else{
                right=mid-1;
            }
        }
        ans[i]=value;
        }
        return ans;
    }
}