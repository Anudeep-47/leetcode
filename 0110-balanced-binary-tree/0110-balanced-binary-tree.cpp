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
private:
    bool is_height_balanced(TreeNode* node, int &height) {
        if (node == nullptr) {
            height = -1;
            return true;
        }
        int left_height {}, right_height {};
        if (is_height_balanced(node->left, left_height) 
                && is_height_balanced(node->right, right_height) 
                    && abs(left_height-right_height)<2) {
            height = 1 + max(left_height, right_height);
            return true;
        }
        return false;
    }

public:
    bool isBalanced(TreeNode* root) {
        int height {};
        return is_height_balanced(root, height);
    }
};