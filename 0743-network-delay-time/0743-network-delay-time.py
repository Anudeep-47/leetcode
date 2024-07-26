class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj_list = defaultdict(list)
        for s, d, t in times:
            adj_list[s].append((t, d))
        visit_set = set()
        heap = [(0, k)]
        while heap:
            t, node = heapq.heappop(heap)
            visit_set.add(node)
            if len(visit_set) == n:
                return t
            for dt, d in adj_list[node]:
                if d not in visit_set:
                    heapq.heappush(heap, (t+dt, d))
        return -1