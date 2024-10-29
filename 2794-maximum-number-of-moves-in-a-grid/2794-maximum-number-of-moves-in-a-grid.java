class Solution {
    public int maxMoves(int[][] grid) {
        int maxLen=0;
        int n= grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            dp[i][0]=maxL(i,0,grid,dp);
            maxLen=Math.max(maxLen,dp[i][0]);
            if (maxLen>=m-1)return maxLen;
        }
    return maxLen;
    }

    private int  maxL(int row,int col,int[][] grid,int[][] dp){
        if (dp[row][col]!=0) return dp[row][col];


        if (col!=grid[row].length-1){
            if (row>0){
                if (grid[row-1][col+1]>grid[row][col]){
                    dp[row][col]=Math.max(dp[row][col],1+maxL(row-1,col+1,grid,dp));
                }
            }if (row<grid.length-1){
                if (grid[row+1][col+1]>grid[row][col]){
                    dp[row][col]=Math.max(dp[row][col],1+maxL(row+1,col+1,grid,dp));
                }
            }
            if (grid[row][col+1]>grid[row][col]){
                dp[row][col]=Math.max(dp[row][col],1+maxL(row,col+1,grid,dp));
            }
        }
        return dp[row][col];
    }
}