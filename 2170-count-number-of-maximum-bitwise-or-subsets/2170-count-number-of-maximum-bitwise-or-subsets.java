class Solution {
    public int countMaxOrSubsets(int[] nums) {
         List<List<Integer>> list=new ArrayList<>();
         subset(nums,new ArrayList<>(),0,list);
return countMax(list);
    }
    public static int countMax(List<List<Integer>> list){
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<list.size();i++){
            int or=0;
            for(int j=0;j<list.get(i).size();j++){
                or=or|list.get(i).get(j);
            }
            max=Math.max(or,max);
        }
        return noOFSets(list,max);
    }
    public static int noOFSets(List<List<Integer>> list,int max){
        int count=0;
        for(int i=0;i<list.size();i++){
            int or=0;
            for(int j=0;j<list.get(i).size();j++){
                or=or|list.get(i).get(j);
            }
            if(or==max){
                count++;
            }
        
        }
        return count;
    }
    public static void subset(int nums[],ArrayList<Integer>sublist,int i, List<List<Integer>> list){
        
        if(i==nums.length){
            list.add(new ArrayList<>(sublist));

            return;
        }
        sublist.add(nums[i]);
        subset(nums,sublist,i+1,list);
         sublist.remove(sublist.size() - 1);
        subset(nums,sublist,i+1,list);

    }
}