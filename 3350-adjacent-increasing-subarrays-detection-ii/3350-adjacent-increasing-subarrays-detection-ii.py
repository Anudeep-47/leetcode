class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        cur_size = 1
        prev_size = 0
        res = 0
        for i in range(1, n):
            if nums[i-1]<nums[i]:
                cur_size += 1
            else:
                prev_size = cur_size
                cur_size = 1
            res = max(res, cur_size//2, min(prev_size, cur_size))
        return res