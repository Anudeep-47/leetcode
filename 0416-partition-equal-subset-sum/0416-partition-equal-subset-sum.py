class Solution:
    # # dp with memoization O(n^2) space
    # def canPartition(self, nums: List[int]) -> bool:
    #     total_sum = sum(nums)
    #     if total_sum % 2 != 0:
    #         return False
    #     subset_sum = total_sum//2
    #     n = len(nums)
    #     memo = [[None]*subset_sum for _ in range(n)]
    #     def recursion(index, sub_sum, memo):
    #         if index < 0 and sub_sum == 0:
    #             return True
    #         if index < 0 and sub_sum > 0:
    #             return False
    #         if memo[index][sub_sum-1] != None:
    #             return memo[index][sub_sum-1]
    #         if sub_sum >= nums[index]:
    #             memo[index][sub_sum-1] = recursion(index-1, sub_sum, memo) or recursion(index-1, sub_sum-nums[index], memo)
    #         else:
    #             memo[index][sub_sum-1] = recursion(index-1, sub_sum, memo)
    #         return memo[index][sub_sum-1]
    #     return recursion(n-1, subset_sum, memo)
    
    # # dp O(n^2) space
    # def canPartition(self, nums: List[int]) -> bool:
    #     total_sum = sum(nums)
    #     if total_sum % 2 != 0:
    #         return False
    #     subset_sum = total_sum//2
    #     n = len(nums)
    #     dp = [[False]*(subset_sum+1) for _ in range(n+1)]
    #     dp[0][0] = True
    #     for i in range(1, n+1):
    #         for j in range(subset_sum+1):
    #             if j < nums[i-1]:
    #                 dp[i][j] = dp[i-1][j]
    #             else:
    #                 dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]
    #     return dp[n][subset_sum]

    # dp O(n) space
    def canPartition(self, nums: List[int]) -> bool:
        total_sum = sum(nums)
        if total_sum % 2 != 0:
            return False
        subset_sum = total_sum//2
        n = len(nums)
        dp = [False]*(subset_sum+1)
        dp[0] = True
        for i in range(n):
            for j in range(subset_sum, 0, -1):
                if j>=nums[i]:
                    dp[j] = dp[j] or dp[j-nums[i]]
        return dp[subset_sum]





