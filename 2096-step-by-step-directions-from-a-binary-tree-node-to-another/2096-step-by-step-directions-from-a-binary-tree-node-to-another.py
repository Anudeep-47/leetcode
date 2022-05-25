# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        def findPath(node: TreeNode, value: int, path: list) -> bool:
            if node.val == value:
                return True
            if node.left and findPath(node.left, value, path):
                path.append('L')
            elif node.right and findPath(node.right, value, path):
                path.append('R')
            return path
        startPath = []
        destPath = []
        findPath(root, startValue, startPath)
        findPath(root, destValue, destPath)
        while startPath and destPath and startPath[-1] == destPath[-1]:
            startPath.pop()
            destPath.pop()
        return 'U'*len(startPath) + ''.join(reversed(destPath))