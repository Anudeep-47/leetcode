/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        Node leftyRight = node.right;
        while(leftyRight!=null && leftyRight.left!=null){
            leftyRight = leftyRight.left;
        }
        if(leftyRight!=null)return leftyRight;
        Node rightyParent = node.parent;
        while(rightyParent!=null && rightyParent.left!=node){
            node = rightyParent;
            rightyParent = rightyParent.parent;
        }
        return rightyParent;
    }
}