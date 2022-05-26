# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDistance(self, root: Optional[TreeNode], p: int, q: int) -> int:
        def lca(node: TreeNode, p, q) -> TreeNode:
            if node is None or (node.val == p or node.val == q):
                return node
            leftNode = lca(node.left, p, q)
            rightNode = lca(node.right, p, q)
            return node if leftNode and rightNode else leftNode or rightNode
        def dist(node: TreeNode, target: int):
            if node is None:
                return float('inf')
            if node.val == target:
                return 0;
            return 1 + min(dist(node.left, target), dist(node.right, target))
        lcaNode = lca(root, p, q)
        return dist(lcaNode, p) + dist(lcaNode, q)