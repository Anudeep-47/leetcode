class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_buy = prices[0]
        profit = 0
        for p in prices:
            if min_buy > p:
                min_buy = p
            if p-min_buy > profit:
                profit = p-min_buy
        return profit
