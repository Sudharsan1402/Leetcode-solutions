class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: arr){
            int remainder = num%k;
            if(remainder<0){
                remainder += k;
            }
            map.put(remainder, map.getOrDefault(remainder, 0) +1);
        }

        for(int rem: map.keySet()){
            int count = map.get(rem);
            if(rem == 0){
                if(count%2 != 0){
                    return false;
                }
            }
            else{
                int complement = k-rem;
               if(map.getOrDefault(complement, 0) != count){
                return false;
               }
            }
        }
        return true;
        
    }
}