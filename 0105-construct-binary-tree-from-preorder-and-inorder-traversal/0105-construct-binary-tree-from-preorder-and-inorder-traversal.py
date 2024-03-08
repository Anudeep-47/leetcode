# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
    #     if not preorder or not inorder:
    #         return None
    #     node = TreeNode(preorder[0])
    #     idx = inorder.index(node.val)
    #     node.left = self.buildTree(preorder[1:idx+1], inorder[:idx])
    #     node.right = self.buildTree(preorder[idx+1:], inorder[idx+1:])
    #     return node
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        val_to_idx = {val: idx for idx, val in enumerate(inorder)}
        def builder(pre_start, pre_end, in_start, in_end):
            if pre_start>pre_end or in_start>in_end:
                return None
            node = TreeNode(preorder[pre_start])
            idx = val_to_idx[node.val]
            nums = idx-in_start
            node.left = builder(pre_start+1, pre_start+nums, in_start, idx-1)
            node.right = builder(pre_start+nums+1, pre_end, idx+1, in_end)
            return node
        return builder(0, len(preorder)-1, 0, len(inorder)-1)