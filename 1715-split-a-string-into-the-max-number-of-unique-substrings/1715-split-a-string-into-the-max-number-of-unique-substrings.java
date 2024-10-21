class Solution {
    int Count;
    public int maxUniqueSplit(String s) {
        Count=0;
        HashSet<String>set = new HashSet<>();
        back_track(s,set,0);
        return Count;
    }
    public void back_track(String s, HashSet<String> set, int index){
        int n = s.length();
        if(index==n){
            Count = Math.max(Count,set.size());
            return;
        }
        for(int i=index;i<n;i++){
            String sub = s.substring(index,i+1);
            if(!set.contains(sub)){
                set.add(sub);
                back_track(s,set,i+1);
                set.remove(sub);
            }
        }
    }
    
}