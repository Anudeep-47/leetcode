class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        cur_size = 1
        prev_max = 0
        res = 0
        for i in range(1, n):
            if nums[i-1]<nums[i]:
                cur_size += 1
            else:
                prev_max = cur_size
                cur_size = 1
            res = max(res, min(prev_max, cur_size), cur_size//2)
        return res >= k