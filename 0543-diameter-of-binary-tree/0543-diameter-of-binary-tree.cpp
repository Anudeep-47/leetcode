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
    int diameterHelper(TreeNode* node, int& diameter) {
        if (node == nullptr) return 0;
        int left { diameterHelper(node->left, diameter) };
        int right { diameterHelper(node->right, diameter) };
        diameter = max(diameter, left+right);
        return max(left, right)+1;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        int diameter {};
        diameterHelper(root, diameter);
        return diameter;
    }
};