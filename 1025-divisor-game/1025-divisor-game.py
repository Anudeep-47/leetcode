class Solution:
    def divisorGame(self, n: int) -> bool:
        # dp = [False]*n
        # for i in range(2, n+1):
        #     for j in range(i-1, 0, -1):
        #         if j == 1 or (i%j==0 and not dp[i-j]):
        #             dp[i-1] = not dp[i-j-1]
        # return dp[-1]

        return n%2 == 0