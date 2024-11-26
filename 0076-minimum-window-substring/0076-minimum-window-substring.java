class Solution {
    public String minWindow(String s, String t) {
        int ascii[] = new int[128];
        for(char ch:t.toCharArray()){
            ascii[ch]++;
        }
        int counter = t.length(),start=0,minStart=0,minLen=Integer.MAX_VALUE;
        for(int index=0;index<s.length();index++){
            char ch = s.charAt(index);
            if(ascii[ch]>0){
                counter--;
            }ascii[ch]--;
            while(counter==0){
                if(minLen>index-start+1){
                    minLen = index-start+1;
                    minStart=start;
                }
                char front = s.charAt(start);
                ascii[front]++;
                if(ascii[front]>0){
                    counter++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
        
    }
}