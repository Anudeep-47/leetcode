# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        level_q = deque()
        level_q.append(root)
        while len(level_q)>0:
            level_size = len(level_q)
            level_sum, last_level = 0, True
            for _ in range(level_size):
                node = level_q.popleft()
                level_sum += node.val
                if node.left:
                    last_level = False
                    level_q.append(node.left)
                if node.right:
                    last_level = False
                    level_q.append(node.right)
            if last_level:
                return level_sum
        return -1