class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        prev = nums[0]
        cur = max(nums[0], nums[1])
        for n in nums[2:]:
            temp = max(cur, n+prev)
            prev = cur
            cur = temp
        return cur