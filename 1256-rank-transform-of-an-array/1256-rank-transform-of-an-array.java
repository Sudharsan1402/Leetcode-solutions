class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] arr1 = new int [arr.length];
        arr1 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr1);
        Map<Integer,Integer> map = new HashMap<>();
        int x = 1;
        for(int i:arr1){
            if(map.containsKey(i)){
                map.put(i,map.get(i));
            }
            else{
                map.put(i,x);
                x++;
            }
        }
        int [] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr2[i] = map.get(arr[i]);
        }
        return arr2;

    }
}