class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j] = 0;
            }
        }
        int ans = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans = Math.max(ans, solve(matrix,i,j,row,col,dp));
            }
        }
        return ans;

        
    }

    public int solve(int[][] matrix,int i,int j,int row,int col,int[][] dp){
        if(i<0 || j<0 || i>=row || j>=col){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        int a=1,b=1,c=1,d=1;
        if(i<row-1 && matrix[i+1][j] > matrix[i][j]){
            a = 1+solve(matrix,i+1,j,row,col,dp);
        }
        if(i>0 && matrix[i-1][j] > matrix[i][j]){
            b = 1+solve(matrix,i-1,j,row,col,dp);
        }
        if(j<col-1 && matrix[i][j+1] > matrix[i][j]){
            c = 1+solve(matrix,i,j+1,row,col,dp);
        }
        if(j>0 && matrix[i][j-1] > matrix[i][j]){
            d = 1+solve(matrix,i,j-1,row,col,dp);
        }

        return dp[i][j] = Math.max(Math.max(a,b), Math.max(c,d));

    }
}