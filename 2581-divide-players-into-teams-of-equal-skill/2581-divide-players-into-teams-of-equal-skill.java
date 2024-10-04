class Solution {
    public long dividePlayers(int[] skill) {
        int N = skill.length;
        int a;
        long sum = 0;
        Arrays.sort(skill);
        int tot = skill[0]+skill[N-1];
         if(N == 2){
                return skill[0]*skill[1];
            }
        for(int i=0;i<N;i++){
           
            if(skill[i]+skill[N-i-1] == tot ){
                a = skill[i]*skill[N-i-1];
                sum += a;
                
            }
            else{
                return -1;
            }
            


        }
        return sum/2;
        
        
    }
}