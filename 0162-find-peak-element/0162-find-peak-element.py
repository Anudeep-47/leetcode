class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1 or nums[0]>nums[1]:
            return 0
        if nums[-2]<nums[-1]:
            return len(nums)-1
        i, j = 1, len(nums)-2
        while i<=j:
            mid = i+(j-i)//2
            if nums[mid-1]<nums[mid]>nums[mid+1]:
                return mid
            if nums[mid-1]>nums[mid]:
                j = mid-1
            else:
                i = mid+1
        return 0