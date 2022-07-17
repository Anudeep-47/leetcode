class LRUCache {
    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
    }
    
    private void addNode(DoubleLinkedNode node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        return;
    }
    
    private void removeNode(DoubleLinkedNode node){
        DoubleLinkedNode beforeNode = node.prev;
        DoubleLinkedNode afterNode = node.next;
        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;
        return;
    }
    
    private int popTail(){
        DoubleLinkedNode node = tail.prev;
        removeNode(node);
        return node.key;
    }
    
    private Map<Integer, DoubleLinkedNode> map = new HashMap<>();
    private DoubleLinkedNode head, tail;
    private int size, capacity;
    
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = map.get(key);
        if(node == null)return -1;
        removeNode(node);
        addNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = map.get(key);
        if(node == null){
            node = new DoubleLinkedNode();
            node.key = key;
            node.value = value;
            map.put(key, node);
            if (size==capacity){
                map.remove(popTail());
                size--;
            }
            addNode(node);
            size++;
        }
        else {
            node.value = value;
            removeNode(node);
            addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */