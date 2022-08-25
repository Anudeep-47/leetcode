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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursivePathSum(root);
        return maxSum;
    }
    private int recursivePathSum(TreeNode node){
        if(node==null)return 0;
        int left = recursivePathSum(node.left);
        int right = recursivePathSum(node.right);
        maxSum = Math.max(maxSum, Math.max(node.val, Math.max(node.val+left+right, Math.max(node.val+left, node.val+right))));
        return Math.max(node.val, Math.max(node.val+left, node.val+right));
    }
}