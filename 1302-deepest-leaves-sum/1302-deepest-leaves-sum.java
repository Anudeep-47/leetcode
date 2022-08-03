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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> bfsQueue = new ArrayDeque<>();
        int deepSum=0;
        bfsQueue.add(root);
        while(!bfsQueue.isEmpty()){
            deepSum=0;
            int size = bfsQueue.size();
            for(int i=0; i<size; i++){
                TreeNode node = bfsQueue.poll();
                if(node.left==null && node.right==null)deepSum += node.val;
                if(node.left!=null)bfsQueue.add(node.left);
                if(node.right!=null)bfsQueue.add(node.right);
            }
        }
        return deepSum;
    }
}