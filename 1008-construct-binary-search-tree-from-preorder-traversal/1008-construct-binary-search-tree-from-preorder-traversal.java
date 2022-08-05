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
    public TreeNode bstFromPreorder(int[] preorder) {
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode head = new TreeNode(preorder[0]);
        stk.push(head);
        for(int i=1; i<preorder.length; i++){
            TreeNode node = new TreeNode(preorder[i]);
            if(stk.peek().val>node.val){
                stk.peek().left = node;
            }
            else {
                while(!stk.isEmpty() && stk.peek().val < node.val){
                    TreeNode prevNode = stk.pop();
                    if(stk.isEmpty() || stk.peek().val > node.val){
                        prevNode.right = node;
                    }
                }
            }
            stk.push(node);
        }
        return head;
    }
}