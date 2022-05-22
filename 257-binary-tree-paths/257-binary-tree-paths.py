# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreeRecursive(self, node, path, path_list):
        if node.left is None and node.right is None:
            path_list.append(path)
            return
        if node.left is not None:
            self.binaryTreeRecursive(node.left, f'{path}->{node.left.val}', path_list)    
        if node.right is not None:
            self.binaryTreeRecursive(node.right, f'{path}->{node.right.val}', path_list)
    
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if root is None: return []
        path_list = []
        self.binaryTreeRecursive(root, f'{root.val}', path_list)
        return path_list