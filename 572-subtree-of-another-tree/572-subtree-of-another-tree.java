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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        return isSubtreeEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSubtreeEqual(TreeNode node, TreeNode subRootNode){
        if(node==null && subRootNode==null)return true;
        if(node==null || subRootNode==null) return false;
        if(node.val != subRootNode.val)return false;
        return isSubtreeEqual(node.left, subRootNode.left) && isSubtreeEqual(node.right, subRootNode.right);
    }
}