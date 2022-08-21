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
    
    private ListNode reverseKList(ListNode head, int k){
        ListNode prev, cur;
        prev = null;
        cur = head;
        while(k>0){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur, newHead, tail;
        newHead = null;
        tail = null;
        cur = head;
        while(cur!=null){
            int count = 0;
            while(count < k && cur!=null){
                cur = cur.next;
                count++;
            }
            if(count == k){
                ListNode reversedHead = reverseKList(head, k);
                if(newHead==null){
                    newHead = reversedHead;
                }
                if(tail!=null){
                    tail.next = reversedHead;
                }
                tail = head;
                head = cur;
            }
        }
        if(tail!=null){
            tail.next = head;
        }
        return newHead == null ? head : newHead;
    }
}