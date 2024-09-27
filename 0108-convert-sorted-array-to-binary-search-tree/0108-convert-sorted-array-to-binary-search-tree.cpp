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
    TreeNode* insertBSTrecursive(vector<int>& nums, int left, int right) {
        if (left>right) return nullptr;
        int mid { left+(right-left)/2 };
        TreeNode* node { new TreeNode(nums[mid]) };
        node->left = insertBSTrecursive(nums, left, mid-1);
        node->right = insertBSTrecursive(nums, mid+1, right);
        return node;
    }

    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return insertBSTrecursive(nums, 0, static_cast<int>(nums.size()-1));
    }
};