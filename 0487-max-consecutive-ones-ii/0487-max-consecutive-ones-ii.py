class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        zero_index = -1
        max_ones = 0
        start = 0
        n = len(nums)
        for end in range(n):
            if nums[end] == 0:
                start = zero_index+1
                zero_index = end
            max_ones = max(max_ones, end-start+1)
        return max_ones