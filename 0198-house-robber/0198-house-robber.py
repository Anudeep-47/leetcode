class Solution:
    def rob(self, nums: List[int]) -> int:
        first, second = 0, nums[0]
        for i in range(1, len(nums)):
            temp = max(first+nums[i], second)
            first, second = second, temp
        return max(first, second)