# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        if list2 is None:
            return list1
        if list1.val > list2.val:
            list1, list2 = list2, list1
        temp1 = list1
        while temp1.next is not None and list2 is not None:
            if temp1.next.val > list2.val:
                temp2 = list2.next
                list2.next = temp1.next
                temp1.next = list2
                list2 = temp2
            temp1 = temp1.next
        if list2 is not None:
            temp1.next = list2
        return list1
        