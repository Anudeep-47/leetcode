class Solution:
    # # dp with memoization O(n^2) space
    # def longestCommonSubsequence(self, text1: str, text2: str) -> int:
    #     m, n = len(text1), len(text2)
    #     memo = [[-1]*n for _ in range(m)]
    #     def recursion(index1, index2, m, n, memo):
    #         if index1 == m or index2 == n:
    #             return 0
    #         if memo[index1][index2]!=-1:
    #             return memo[index1][index2]
    #         if text1[index1] == text2[index2]:
    #             memo[index1][index2] = 1 + recursion(index1+1, index2+1, m, n, memo)
    #         else:
    #             memo[index1][index2] = max(recursion(index1+1, index2, m, n, memo), recursion(index1, index2+1, m, n, memo))
    #         return memo[index1][index2]
    #     return recursion(0, 0, m, n, memo)

    # # dp with O(n^2) space
    # def longestCommonSubsequence(self, text1: str, text2: str) -> int:
    #     m, n = len(text1), len(text2)
    #     dp = [[-1]*(n+1) for _ in range(m+1)]
    #     for i in range(m+1):
    #         for j in range(n+1):
    #             if i==0 or j==0:
    #                 dp[i][j] = 0
    #             else:
    #                 if text1[i-1] == text2[j-1]:
    #                     dp[i][j] = 1+dp[i-1][j-1]
    #                 else:
    #                     dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    #     return dp[m][n]

    # dp with O(min(m, n)) space
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) > len(text2):
            text1, text2 = text2, text1
        m, n = len(text1), len(text2)
        prev_dp = [0]*(m+1)
        cur_dp = [0]*(m+1)
        for i in range(n):
            for j in range(m):
                if text1[j] == text2[i]:
                    cur_dp[j+1] = 1 + prev_dp[j]
                else:
                    cur_dp[j+1] = max(prev_dp[j+1], cur_dp[j])
            prev_dp, cur_dp = cur_dp, prev_dp
        return prev_dp[m]

        
