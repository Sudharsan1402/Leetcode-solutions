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
class Pair{
    int order;
    TreeNode parent;
    TreeNode currentNode;
}
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return root;
        }
        q.add(root);
        int prev = root.val;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size>0){
                TreeNode n = q.poll();
                int siblingSum = 0;
                if(n.left!=null){
                    siblingSum+=n.left.val;
                }
                if(n.right!=null){
                    siblingSum+=n.right.val;
                }
                if(n.left!=null){
                    q.add(n.left);
                    n.left.val = siblingSum;
                }
                if(n.right!=null){
                    q.add(n.right);
                    n.right.val = siblingSum;
                }
                size--;
                sum+=siblingSum;
                n.val = prev - n.val;
            }
            prev = sum;

            System.out.println(sum);
        }
        return root;
    }
}