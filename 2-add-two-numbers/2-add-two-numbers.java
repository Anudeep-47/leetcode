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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int num = 0;
            if(l1!=null){
                num += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                num += l2.val;
                l2 = l2.next;
            }
            if(carry>0){
                num += carry;
            }
            node.next = new ListNode(num%10);
            carry = num/10;
            node = node.next;
        }
        return head.next;
    }
}