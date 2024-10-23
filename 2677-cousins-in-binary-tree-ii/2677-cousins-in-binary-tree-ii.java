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
    public TreeNode replaceValueInTree(TreeNode root) {
        int curLvlSum = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val *= -1;
        while(!q.isEmpty()) {
            int sz = q.size();
            int newLvlSum = 0;
            for(int i=0; i<sz; ++i) {
                TreeNode cur = q.poll();
                int childSum = 0;
                if(cur.left!=null) childSum += cur.left.val;
                if(cur.right!=null) childSum += cur.right.val;
                newLvlSum += childSum;
                if(cur.left!=null) cur.left.val = -childSum;
                if(cur.right!=null) cur.right.val = -childSum;
                cur.val += curLvlSum;
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null) q.offer(cur.right);
            }
            curLvlSum = newLvlSum;
        }
        return root;
    }
}