class Solution:
    def earliestAcq(self, logs: List[List[int]], n: int) -> int:
        if len(logs)<n-1:
            return -1
        logs.sort()
        uf = UnionFind(n)
        groups = n
        for log in logs:
            timestamp, x, y = log
            if uf.union(x, y):
                groups -= 1
            if groups == 1:
                return timestamp
        return -1
    
class UnionFind:
    def __init__(self, n):
        self.groups = [p for p in range(n)]
        self.rank = [0]*n
    
    def find(self, a):
        if self.groups[a] == a:
            return a
        return self.find(self.groups[a])
    
    def union(self, a, b):
        group_a = self.find(a)
        group_b = self.find(b)
        if group_a == group_b:
            return False
        if self.rank[group_a] > self.rank[group_b]:
            self.groups[group_b] = group_a
        elif self.rank[group_a] < self.rank[group_b]:
            self.groups[group_a] = group_b
        else:
            self.groups[group_b] = group_a
            self.rank[group_a] += 1
        return True