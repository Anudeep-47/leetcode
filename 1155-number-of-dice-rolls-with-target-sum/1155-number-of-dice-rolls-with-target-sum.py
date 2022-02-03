class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        dp_map = {}
        def dp(d, t):
            if d==0:
                return 1 if t==0 else 0
            if (d, t) in dp_map:
                return dp_map[(d, t)]
            result = 0
            for val in range(max(0, t-k), t):
                result += dp(d-1, val)
            dp_map[(d, t)] = result
            return result
        return dp(n, target) % (10**9+7)