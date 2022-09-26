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
    public boolean isPalindrome(ListNode head) {
        ListNode first = head.next;
        ListNode second = head;
        while(first!=null && first.next!=null){
            first = first.next.next;
            second = second.next;
        }
        second.next = reverseList(second.next);
        first = second.next;
        ListNode temp = second;
        second = head;
        while(first!=null){
            if(first.val!=second.val)return false;
            first = first.next;
            second = second.next;
        }
        temp.next = reverseList(temp.next);
        return true;
    }
    private ListNode reverseList(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode prev, cur, next;
        prev = null;
        cur = head;
        next = head.next;
        while(cur!=null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(cur!=null)next = cur.next;
        }
        return prev;
    }
}