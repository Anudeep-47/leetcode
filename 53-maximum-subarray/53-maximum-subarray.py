class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = -float('inf')
        num_sum = 0
        for n in nums:
            num_sum = max(n, num_sum+n)
            max_sum = max(max_sum, num_sum)
        return max_sum