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
    public int sumRootToLeaf(TreeNode root) {
        return recursiveSum(root, 0, 0);
    }
    private int recursiveSum(TreeNode node, int val, int total){
        val <<= 1;
        if(node.val==1)val |= 1;
        if(node.left==null && node.right==null){
            total += val;
            return total;
        }
        if(node.left!=null){
            total = recursiveSum(node.left, val, total);
        }
        if(node.right!=null){
            total = recursiveSum(node.right, val, total);
        }
        return total;
    }
}