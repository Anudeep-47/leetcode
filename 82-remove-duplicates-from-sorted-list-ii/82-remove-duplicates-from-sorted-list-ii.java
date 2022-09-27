/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                int val = cur.val;
                while(cur!=null && cur.val==val)cur = cur.next;
                prev.next = cur;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}