class Solution {
   public boolean detectCycle(List<List<Integer>> v, int src, int[] rst, int[] vis) {
        vis[src] = 1;
        rst[src] = 1;
        for (int x : v.get(src)) {
            if (vis[x] == 0 && detectCycle(v, x, rst, vis)) {
                return true;
            } else if (rst[x] == 1) {
                return true;
            }
        }
        rst[src] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> v = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            v.add(new ArrayList<>());
        }
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[numCourses];
        int[] rst = new int[numCourses];
        for (int[] x : prerequisites) {
            v.get(x[1]).add(x[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0 && detectCycle(v, i, rst, vis)) {
                return false;
            }
        }
        return true;
    }
}