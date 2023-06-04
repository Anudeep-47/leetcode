"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return head
        p1 = head
        while p1:
            new_node = Node(p1.val)
            new_node.next = p1.next
            p1.next = new_node
            p1 = new_node.next
        p1 = head
        while p1:
            if p1.random:
                p1.next.random = p1.random.next
            p1 = p1.next.next
        new_head = head.next
        p1, p2 = head, new_head
        while p2:
            p1.next = p2.next
            if p2.next:
                p2.next = p2.next.next
            p1 = p1.next
            p2 = p2.next
        return new_head
        
