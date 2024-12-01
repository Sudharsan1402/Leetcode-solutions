class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=0;j<n;j++){
                if(i!=j && arr[i] == 2*arr[j]){
                    found = true;
                    break;
                }
            }
            if(found == true){
                return true;
            }

        }
        return false;
        
    }
}