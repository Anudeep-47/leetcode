class Solution:
    # # recursion with memoization
    # def numDecodings(self, s: str) -> int:
    #     dp = {}
    #     def recursive(index):
    #         if index in dp:
    #             return dp[index]
    #         if index == len(s):
    #             return 1
    #         if s[index] == '0':
    #             return 0
    #         if index == len(s)-1:
    #             return 1
    #         res = recursive(index+1)
    #         if int(s[index:index+2]) <= 26:
    #             res += recursive(index+2)
    #         dp[index] = res
    #         return res
    #     return recursive(0)

    # # dp O(n) space
    # def numDecodings(self, s: str) -> int:
    #     n = len(s)
    #     dp = [0]*(n+1)
    #     dp[0] = 1
    #     dp[1] = 0 if s[0]=='0' else 1
    #     for i in range(2, len(dp)):
    #         if s[i-1] != '0':
    #             dp[i] = dp[i-1]
    #         two_digit = int(s[i-2:i])
    #         if two_digit >= 10 and two_digit <= 26:
    #             dp[i] += dp[i-2]
    #     return dp[n]

    # dp O(1) space
    def numDecodings(self, s: str) -> int:
        first, second = 1, 0 if s[0]=='0' else 1
        for i in range(1, len(s)):
            temp = second if s[i]!='0' else 0
            two_digit = int(s[i-1:i+1])
            if two_digit >= 10 and two_digit<=26:
                temp += first
            first, second = second, temp
        return second







