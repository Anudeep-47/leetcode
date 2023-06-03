class Solution:
    # # binary search
    # def search(self, nums: List[int], target: int) -> int:
    #     n = len(nums)
    #     left, right = 0, n-1
    #     while left<=right:
    #         mid = left + (right-left)//2
    #         if nums[mid] == target:
    #             return mid
    #         if nums[mid] < target:
    #             left = mid+1
    #         else:
    #             right = mid-1
    #     return -1

    # # finding the upper bound
    # def search(self, nums: List[int], target: int) -> int:
    #     n = len(nums)
    #     left, right = 0, n
    #     while left<right:
    #         mid = left + (right-left)//2
    #         if nums[mid] <= target:
    #             left = mid+1
    #         else:
    #             right = mid
    #     if left>0 and nums[left-1] == target:
    #         return left-1
    #     return -1

    # # finding the lower bound
    # def search(self, nums: List[int], target: int) -> int:
    #     n = len(nums)
    #     left, right = 0, n
    #     while left<right:
    #         mid = left + (right-left)//2
    #         if nums[mid] < target:
    #             left = mid+1
    #         else:
    #             right = mid
    #     if left<n and nums[left] == target:
    #         return left
    #     return -1

    # built in methods
    def search(self, nums: List[int], target: int) -> int:
        index = bisect.bisect_right(nums, target)
        if index>0 and nums[index-1] == target:
            return index-1
        return -1
    