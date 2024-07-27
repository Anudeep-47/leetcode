class Solution:
    def gardenNoAdj(self, n: int, paths: List[List[int]]) -> List[int]:
        result = [0]*n
        adj_list = defaultdict(list)
        for g1, g2 in paths:
            adj_list[g1].append(g2)
            adj_list[g2].append(g1)
        for g in range(1, n+1):
            flowers = set([result[g1-1] for g1 in adj_list[g] if result[g1-1]])
            f = 0
            while f+1 in flowers:
                f = (f+1)%4
            result[g-1] = f+1
        return result