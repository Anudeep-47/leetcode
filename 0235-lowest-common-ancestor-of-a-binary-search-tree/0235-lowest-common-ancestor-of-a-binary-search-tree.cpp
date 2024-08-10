/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // solution for only binary tree
        // if (root == nullptr || root == p || root == q) return root;
        // TreeNode* left = lowestCommonAncestor(root->left, p, q);
        // TreeNode* right = lowestCommonAncestor(root->right, p, q);
        // return left!=nullptr && right!=nullptr ? root : left!=nullptr ? left : right;

        // solution for BST
        int p_val { p->val }, q_val { q->val };
        TreeNode* node { root };
        while (node!=nullptr) {
            int node_val { node->val };
            if (node_val < p_val && node_val < q_val) {
                node = node->right;
            }
            else if (p_val < node_val && q_val < node_val) {
                node = node->left;
            }
            else {
                return node;
            }
        }
        return nullptr;
    }
};