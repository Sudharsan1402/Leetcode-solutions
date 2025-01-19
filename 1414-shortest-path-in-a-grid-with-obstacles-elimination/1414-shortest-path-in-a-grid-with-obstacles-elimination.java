class Solution {
    public int shortestPath(int[][] g, int k) {
        int m = g.length;
        int n = g[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int[] f = {0, 1, 0, -1, 0};
        int[][] v = new int[m][n];
        Arrays.stream(v).forEach(i -> Arrays.fill(i, k + 1));
        dq.offer(new int[]{0, 0, 0});
        v[0][0] = 0;
        while (!dq.isEmpty()) {
            int[] i = dq.poll();
            if (i[0] == m - 1 && i[1] == n - 1) return i[2];
            for (int j = 0; j < 4; j++) {
                int x = i[0] + f[j];
                int y = i[1] + f[j + 1];
                if (0 <= x && x < m && 0 <= y && y < n && v[i[0]][i[1]] + g[x][y] < v[x][y]) {
                    v[x][y] = v[i[0]][i[1]] + g[x][y];
                    dq.offer(new int[]{x, y, i[2] + 1});
                }
            }
        }
        return -1;
    }
}