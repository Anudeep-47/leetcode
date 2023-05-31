class Solution:
    # def countSubstrings(self, s: str) -> int:
    #     n = len(s)
    #     res = 0
    #     dp = [[False]*n for _ in range(n)]
    #     for i in range(n-1, -1, -1):
    #         for j in range(i, n):
    #             dp[i][j] = s[i]==s[j] and (j-i<3 or dp[i+1][j-1])
    #             res += int(dp[i][j])
    #     return res

    def countSubstrings(self, s: str) -> int:
        n = len(s)
        res = 0
        def expandPalindrome(left, right):
            nonlocal res
            while left>=0 and right<n and s[left]==s[right]:
                res += 1
                left -= 1
                right += 1
            return
        for i in range(n):
            expandPalindrome(i, i)
            expandPalindrome(i, i+1)
        return res