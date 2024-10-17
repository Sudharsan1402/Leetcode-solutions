class Solution {
    public int maximumSwap(int num) {
        char [] digits = Integer.toString(num).toCharArray();
        int N = digits.length;
        int [] arr = new int [N];
        arr[N-1] = N-1;
        for(int i=N-2;i>=0;i--){
            if(digits[i] > digits[arr[i+1]]){
                arr[i] = i;
            }
            else{
                arr[i] = arr[i+1];
            }
        }
        for(int i=0;i<N;i++){
            if(digits[i] != digits[arr[i]]){
                swap(digits, i, arr[i]);
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }

    private void swap(char [] digits, int i, int j){
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}