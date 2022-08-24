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
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode prev = null;
        while(root!=null || !stk.isEmpty()){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            if(prev!=null && prev.val >= stk.peek().val){
                return false;
            }
            prev = stk.pop();
            root = prev.right;
        }
        return true;
    }
}