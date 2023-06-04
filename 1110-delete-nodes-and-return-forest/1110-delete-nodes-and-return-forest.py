# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        if root is None:
            return []
        res = []
        delete_set = set(to_delete)
        tree_q = deque()
        tree_q.append([None, root])
        while tree_q:
            parent, node = tree_q.popleft()
            del_flag = node.val in delete_set
            if del_flag and parent is not None:
                if parent.left == node:
                    parent.left = None
                else:
                    parent.right = None
            if parent is None and not del_flag:
                res.append(node)
            if node.left is not None:
                tree_q.append([None if del_flag else node, node.left])
            if node.right is not None:
                tree_q.append([None if del_flag else node, node.right])
        return res
            
        