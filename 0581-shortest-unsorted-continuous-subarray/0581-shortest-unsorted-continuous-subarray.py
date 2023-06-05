class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        min_val, max_val = float('inf'), -float('inf')
        flag = False
        for i in range(1,len(nums)):
            if nums[i-1] > nums[i]:
                flag = True
            if flag:
                min_val = min(min_val, nums[i])
        flag = False
        for i in range(len(nums)-1, 0, -1):
            if nums[i-1] > nums[i]:
                flag = True
            if flag:
                max_val = max(max_val, nums[i-1])
        l = 0
        while l<len(nums):
            if min_val < nums[l]:
                break
            l += 1
        r = len(nums)-1
        while r>=0:
            if max_val > nums[r]:
                break
            r -= 1
        return r-l+1 if r-l >= 0 else 0

