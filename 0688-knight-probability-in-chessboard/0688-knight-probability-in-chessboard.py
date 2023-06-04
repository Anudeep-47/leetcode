class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        moves = [[2,1],[2,-1],[-2,1],[-2,-1],[1,2],[-1,2],[1,-2],[-1,-2]]
        @lru_cache(maxsize = None)
        def recursion(k, r, c):
            nonlocal moves
            if k==0:
                return 1
            prob = 0
            for m in moves:
                if r+m[0]>=0 and r+m[0]<n and c+m[1]>=0 and c+m[1]<n:
                    prob += (1/8)*recursion(k-1, r+m[0], c+m[1])
            return prob
        return recursion(k, row, column)