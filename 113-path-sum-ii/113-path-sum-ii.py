# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def createPaths(node: TreeNode, targetSum: int, curSum: int, path, paths):
            if node is None:
                return
            path.append(node.val)
            curSum += node.val
            createPaths(node.left, targetSum, curSum, path, paths)
            createPaths(node.right, targetSum, curSum, path, paths)
            if node.left is None and node.right is None and curSum == targetSum:
                paths.append(list(path))
            path.pop()
            curSum -= node.val
            
        paths = []
        createPaths(root, targetSum, 0, [], paths)
        return paths
        