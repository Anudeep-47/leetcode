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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)minHeap.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(!minHeap.isEmpty()){
            ListNode newNode = minHeap.poll();
            node.next = newNode;
            node = node.next;
            if(node.next!=null)minHeap.add(node.next);
        }
        return head.next;
    }
}