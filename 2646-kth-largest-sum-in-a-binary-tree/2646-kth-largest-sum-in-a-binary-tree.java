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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(k);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           int len = q.size();
           long sum = 0;
           for(int i = 0;i < len; i++){
            TreeNode top = q.poll();
            sum+=(long) top.val;
            if(top.left != null){
             q.add(top.left);
            }
            if(top.right != null){
             q.add(top.right);
            }
           }
           if(pq.size() == k){
             if(pq.peek() < sum){
                pq.poll();
                pq.add(sum);
             }
           }else{
            pq.add(sum);
           }
        }

        return pq.size() == k ? pq.poll() : -1;
    }
}