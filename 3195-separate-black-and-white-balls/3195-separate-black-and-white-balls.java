class Solution {
    public long minimumSteps(String s) {
        int N = s.length();
        int white = 0;
        long swaps = 0;
        for(int i=0;i<N;i++){
            if(s.charAt(i) == '0'){
                swaps += i-white;
                white++;
            }
        }
        return swaps;
    }
}