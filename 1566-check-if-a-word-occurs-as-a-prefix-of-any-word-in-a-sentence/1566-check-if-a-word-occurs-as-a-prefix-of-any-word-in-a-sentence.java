class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int m = searchWord.length();
        String [] arr = sentence.split(" ");
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i].length() >= m && searchWord.equals(arr[i].substring(0, m))){
                return i+1;
            }
        }
        return -1;
        
    }
}