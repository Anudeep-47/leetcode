class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        first, second = cost[0], cost[1]
        for i in range(2, len(cost)):
            temp = min(first, second) + cost[i]
            first, second = second, temp
        return min(first, second)