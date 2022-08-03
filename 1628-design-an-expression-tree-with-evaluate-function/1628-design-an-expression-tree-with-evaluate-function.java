/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class TreeNode extends Node{
    String val;
    TreeNode left;
    TreeNode right;
    public TreeNode(String val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public int evaluate(){
        if(val.equals("+")){
            return left.evaluate() + right.evaluate();
        }
        if(val.equals("-")){
            return left.evaluate() - right.evaluate();
        }
        if(val.equals("*")){
            return left.evaluate() * right.evaluate();
        }
        if(val.equals("/")){
            return left.evaluate() / right.evaluate();
        }
        return Integer.parseInt(val);
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        for(String val : postfix){
            TreeNode newNode = new TreeNode(val);
            if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")){
                TreeNode right = stk.pop();
                TreeNode left = stk.pop();
                newNode.left = left;
                newNode.right = right;
            }
            stk.push(newNode);
        }
        return stk.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */