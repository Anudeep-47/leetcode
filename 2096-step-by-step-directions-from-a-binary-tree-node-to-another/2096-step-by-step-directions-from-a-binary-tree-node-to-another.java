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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startString = new StringBuilder();
        findPath(root, startValue, startString);
        StringBuilder destString = new StringBuilder();
        findPath(root, destValue, destString);
        startString.reverse();
        destString.reverse();
        int i = 0;
        int maxLen = Math.min(startString.length(), destString.length());
        while(i<maxLen && startString.charAt(i)==destString.charAt(i))i++;
        return "U".repeat(startString.length()-i) + destString.substring(i);
    }
    private boolean findPath(TreeNode node, int val, StringBuilder path){
        if(val == node.val)return true;
        if(node.left!=null && findPath(node.left, val, path)){
            path.append('L');
        }
        else if(node.right!=null && findPath(node.right, val, path)){
            path.append('R');
        }
        return path.length()>0;
    }
}