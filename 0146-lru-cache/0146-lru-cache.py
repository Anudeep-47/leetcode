class DoubleLinkedNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache_map = dict()
        self.size = 0
        self.head = DoubleLinkedNode()
        self.tail = DoubleLinkedNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_node(self, node):
        node.next = self.head.next
        node.prev = self.head
        node.next.prev = node
        node.prev.next = node
        return
    
    def remove_node(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        return

    def move_to_head(self, node):
        self.remove_node(node)
        self.add_node(node)

    def pop_tail_node(self):
        tail_node = self.tail.prev
        self.cache_map.pop(tail_node.key)
        self.remove_node(tail_node)

    def get(self, key: int) -> int:
        if key in self.cache_map:
            node = self.cache_map[key]
            self.move_to_head(node)
            return node.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.cache_map:
            node = self.cache_map[key]
            node.value = value
            self.move_to_head(node)
            return
        new_node = DoubleLinkedNode(key, value)
        if self.size >= self.capacity:
            self.pop_tail_node()
            self.size -= 1
        self.cache_map[key] = new_node
        self.add_node(new_node)
        self.size += 1
        return


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)