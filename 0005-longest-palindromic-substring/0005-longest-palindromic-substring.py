class Solution:
    # def max_palindrome_from_center(self, s: str, left: int, right: int) -> int:
    #     while left>=0 and right<len(s) and s[left]==s[right]:
    #         left -= 1
    #         right += 1
    #     return right-left-1

    # def longestPalindrome(self, s: str) -> str:
    #     start, end = 0, 0
    #     for i in range(len(s)):
    #         odd_len = self.max_palindrome_from_center(s, i, i)
    #         even_len = self.max_palindrome_from_center(s, i, i+1)
    #         new_len = max(odd_len, even_len)
    #         if end-start < new_len:
    #             start = i - (new_len-1)//2
    #             end = i + new_len//2 + 1
    #     return s[start:end]
    
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        start = end = -1
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                dp[i][j] = s[i]==s[j] and (j-i < 3 or dp[i+1][j-1])
                if dp[i][j] and (end==-1 or j-i > end-start):
                    start, end = i, j
        return s[start:end+1]
