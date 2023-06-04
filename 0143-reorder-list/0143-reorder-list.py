# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return head
        # finding middle node
        p1 = p2 = head
        while p2 != None and p2.next != None:
            p1 = p1.next
            p2 = p2.next.next
        # reversing second half
        prev, cur = None, p1
        while cur:
            temp, cur.next = cur.next, prev
            prev, cur = cur, temp
        # merging both
        p1, p2 = head, prev
        while p1 != p2 and p1.next != p2:
            temp = p2.next
            p2.next = p1.next
            p1.next = p2
            p1 = p2.next
            p2 = temp
        return head