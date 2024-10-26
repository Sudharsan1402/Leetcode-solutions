/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int[] level = new int[1000001];
    private int[] height = new int[100001];
    private int[] lvlMxHt = new int[100001];
    private int[] lvlSecMxHt = new int[100001];
    
    int findHeight(TreeNode root, int l) {
        if (root == null) {
            return 0;
        }

        level[root.val] = l;
        height[root.val] = Math.max(findHeight(root.left, l + 1), findHeight(root.right, l + 1)) + 1;
        if (lvlMxHt[l] < height[root.val]) {
            lvlSecMxHt[l] = lvlMxHt[l];
            lvlMxHt[l] = height[root.val];
        } else if (lvlSecMxHt[l] < height[root.val]) {
            lvlSecMxHt[l] = height[root.val];
        }
        return height[root.val];
    }
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root, 0);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int L = level[node];
            int tempResult = L + (lvlMxHt[L] == height[node] ? lvlSecMxHt[L] : lvlMxHt[L]) - 1;
            result[i] = tempResult;
        }
        return result;
    }
}