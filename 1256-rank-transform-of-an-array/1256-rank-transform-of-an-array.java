class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        HashMap<Integer,Integer> a= new HashMap<>();
        int x=1;
        for(int i:arr1){
            if(a.containsKey(i)){
                a.put(i,a.get(i));
            }
            else{
                a.put(i,x);
                x++;
            }
            
        }
        int[] r=new int[arr.length];
        for(int i=0;i<arr.length;i++){
              r[i]=a.get(arr[i]);
        }
        return r;
    }
}