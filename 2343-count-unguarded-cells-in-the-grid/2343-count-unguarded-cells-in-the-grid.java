class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        int unguardedCount = m * n;

        for (char[] row : grid) {
            Arrays.fill(row, '0'); 
        }

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
            unguardedCount--;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
            unguardedCount--;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    // North
                    for (int k = i-1; k >= 0; k--) {
                        if (grid[k][j] == '0') {
                            grid[k][j] = '1';
                            unguardedCount--;
                        } else if (grid[k][j] == 'G' || grid[k][j] == 'W') {
                            break;
                        }
                    }
                    // South
                    for (int k = i+1; k < m; k++) {
                        if (grid[k][j] == '0') {
                            grid[k][j] = '1';
                            unguardedCount--;
                        } else if (grid[k][j] == 'G' || grid[k][j] == 'W') {
                            break;
                        }
                    }
                    // West
                    for (int k = j-1; k >= 0; k--) {
                        if (grid[i][k] == '0') {
                            grid[i][k] = '1';
                            unguardedCount--;
                        } else if (grid[i][k] == 'G' || grid[i][k] == 'W') {
                            break;
                        }
                    }
                    // East
                    for (int k = j+1; k < n; k++) {
                        if (grid[i][k] == '0') {
                            grid[i][k] = '1';
                            unguardedCount--;
                        } else if (grid[i][k] == 'G' || grid[i][k] == 'W') {
                            break;
                        }
                    }
                }
            }
        }
        return unguardedCount;
    }
}