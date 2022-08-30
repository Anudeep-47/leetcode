/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node cur = head;
        while(cur!=null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node newHead = head.next;
        cur = head;
        while(cur!=null){
            Node newCur = cur.next;
            cur.next = newCur.next;
            if(newCur.next!=null){
                newCur.next = newCur.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }
}