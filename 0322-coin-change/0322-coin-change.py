class Solution:
    # # recursion with memoization
    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     def recursive(balance, mem):
    #         if balance < 0:
    #             return -1
    #         if balance == 0:
    #             return 0
    #         if mem[balance-1] != 0:
    #             return mem[balance-1]
    #         min_coins = float('inf')
    #         for coin in coins:
    #             res = recursive(balance-coin, mem)
    #             if res >= 0:
    #                 min_coins = min(min_coins, res+1)
    #         mem[balance-1] = min_coins if min_coins != float('inf') else -1
    #         return mem[balance-1]
    #     return recursive(amount, [0]*amount)

    # dp O(s) space
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')]*(amount+1)
        dp[0] = 0
        for bal in range(1, len(dp)):
            for coin in coins:
                if bal >= coin:
                    dp[bal] = min(dp[bal], dp[bal-coin]+1)
        return dp[amount] if dp[amount] != float('inf') else -1









