/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (root == nullptr) return root;
        queue<TreeNode*> tree_q {};
        tree_q.push(root);
        while (!tree_q.empty()) {
            swap(tree_q.front()->left, tree_q.front()->right);
            if (tree_q.front()->left != nullptr) tree_q.push(tree_q.front()->left);
            if (tree_q.front()->right != nullptr) tree_q.push(tree_q.front()->right);
            tree_q.pop();
        }
        return root;
    }
};