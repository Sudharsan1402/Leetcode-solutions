class Solution {
    public int candy(int[] ratings) {
        int N = ratings.length;
        int sum = 0;
        int [] candies = new int [N];
        Arrays.fill(candies, 1);
        for(int i=0;i<N-1;i++){
            if(ratings[i] < ratings[i+1]){
                candies[i+1] = candies[i]+1;
            }
        }
        for(int i=N-1;i>0;i--){
            if(ratings[i] < ratings[i-1]){
                candies[i-1] = Math.max(candies[i-1], candies[i]+1);
            }
        }
        for(int i=0;i<N;i++){
            sum += candies[i];
        }

        return sum;
    }
}