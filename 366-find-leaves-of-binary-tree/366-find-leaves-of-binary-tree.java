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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        findHeight(root, res);
        return res;
    }
    private int findHeight(TreeNode node, List<List<Integer>> res){
        if(node==null)return -1;
        int leftHeight = findHeight(node.left, res);
        int rightHeight = findHeight(node.right, res);
        int curHeight = 1+Math.max(leftHeight, rightHeight);
        if(res.size()==curHeight){
            res.add(new ArrayList<>());
        }
        res.get(curHeight).add(node.val);
        return curHeight;
    }
}