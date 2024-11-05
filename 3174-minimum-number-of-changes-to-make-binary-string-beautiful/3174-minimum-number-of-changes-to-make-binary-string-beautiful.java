class Solution {
    public int minChanges(String s) {
        int min = 0;
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i) != s.charAt(i+1)){
                min++;
            }
        }
        return min;
        
    }
}