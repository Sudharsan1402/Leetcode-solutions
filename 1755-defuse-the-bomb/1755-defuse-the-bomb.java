class Solution {
    private static int sumOfNextKElements(int [] code,int index,int k){
        int sum=0;
        int arrLength= code.length;
        for(int i=index;i<index+k;i++){
            sum+=code[i%arrLength];
        }
        return sum;
    }
    private static int sumOfPreviousKElements(int [] code,int index,int k){
        int sum=0;
        int previousIndex = index-k;
        int arrLength= code.length;
        for(int i=index;i>previousIndex;i--){
            if(i<0){
                sum+=code[arrLength+i];
            }
            else {
                sum+=code[i];
            }
        }
        return sum;
    }
    public int[] decrypt(int[] code, int k) {
        final int DEFAULT_VALUE=0;
        int[] resultArray = new int[code.length];
        if(k>0){
            for(int i=0;i<code.length;i++){
                resultArray[i]=sumOfNextKElements(code,i+1,k);
            }
        } else if (k<0) {
            for(int i=0;i<code.length;i++){
                resultArray[i]=sumOfPreviousKElements(code,i-1,-k);
            }
        }
        else {
            Arrays.fill(resultArray, DEFAULT_VALUE);
        }
        return resultArray;
    }
}