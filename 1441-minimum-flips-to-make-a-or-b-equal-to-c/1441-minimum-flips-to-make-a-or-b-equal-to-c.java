class Solution {
    public int minFlips(int a, int b, int c) {
        int maxval = Math.max(a, Math.max(b,c));
        int shift=0,count=0;
        while((1 << shift)<= maxval){
            int abit = 1&(a >> shift);
            int bbit = 1&(b >> shift);
            int cbit = 1&(c >> shift);
            if(cbit == 1){
                if(abit == 0 && bbit == 0){
                    count += 1;
                }
            }
            else{

                if(abit == 1 && bbit == 1){
                    count += 2;
                }
                else if(abit == 1 || bbit == 1){
                    count += 1;
                }
            }
            shift++;

        }
        return count;
        
    }
}