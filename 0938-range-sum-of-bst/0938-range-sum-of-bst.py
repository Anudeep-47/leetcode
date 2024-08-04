# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        tree_q = deque()
        tree_q.append(root)
        total_sum = 0
        while tree_q:
            level_size = len(tree_q)
            for _ in range(level_size):
                node = tree_q.popleft()
                if low <= node.val <= high:
                    total_sum += node.val
                if node.left and node.val>low:
                    tree_q.append(node.left)
                if node.right and node.val<high:
                    tree_q.append(node.right)
        return total_sum