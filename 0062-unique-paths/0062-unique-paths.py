class Solution:
    # # dp O(n^2) time and space
    # def uniquePaths(self, m: int, n: int) -> int:
    #     dp = [[1]*n for _ in range(m)]
    #     for i in range(1, m):
    #         for j in range(1, n):
    #             dp[i][j] = dp[i-1][j] + dp[i][j-1]
    #     return dp[m-1][n-1]

    # math (m+n-2)!/(m-1)!(n-1)!
    def uniquePaths(self, m: int, n: int) -> int:
        if m==1 or n==1:
            return 1
        m, n = (n-1, m-1) if m<n else (m-1, n-1)
        res, i, j = 1, 1, m+1
        while j<=m+n:
            res *= j
            res //= i
            i, j = i+1, j+1
        return res