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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        int sumOfLeft = 0;
        TreeNode node;
        rightQueue.add(root);
        while(!leftQueue.isEmpty() || !rightQueue.isEmpty()){
            if(!leftQueue.isEmpty()){
                node = leftQueue.poll();
                if(node.left==null && node.right==null)sumOfLeft += node.val;
                if(node.left!=null)leftQueue.add(node.left);
                if(node.right!=null)rightQueue.add(node.right);
            }
            if(!rightQueue.isEmpty()){
                node = rightQueue.poll();
                if(node.left!=null)leftQueue.add(node.left);
                if(node.right!=null)rightQueue.add(node.right);
            }
        }
        return sumOfLeft;
    }
}