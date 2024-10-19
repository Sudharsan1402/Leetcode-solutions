class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s1 = new StringBuilder("0");
        for(int i=1;i<n && k>s1.length();++i){
            s1.append('1');
            for(int j=s1.length()-2;j>=0;--j){
                char inv = (s1.charAt(j) == '1') ? '0' : '1';
                s1.append(inv);
            }
        }
        return s1.charAt(k-1);


        
    }
}