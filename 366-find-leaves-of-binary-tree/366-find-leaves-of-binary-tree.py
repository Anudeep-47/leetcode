# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        def getNodeHeights(node: TreeNode, h_dict, h_list):
            if node is None:
                return 0
            height = 1 + max(getNodeHeights(node.left, h_dict, h_list), getNodeHeights(node.right, h_dict, h_list))
            if height in h_dict:
                h_dict[height].append(node.val)
            else:
                h_dict[height] = [node.val]
                h_list.append(height)
            return height
        h_dict = dict()
        h_list = []
        getNodeHeights(root, h_dict, h_list)
        return [h_dict[h] for h in h_list]
        