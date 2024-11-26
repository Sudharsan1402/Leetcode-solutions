class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++){
            boolean champ = true;
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(grid[i][j] == 0){
                    champ = false;
                    break;
                }

            }
            if(champ) return i;
        }
        return -1;



        
    }
}