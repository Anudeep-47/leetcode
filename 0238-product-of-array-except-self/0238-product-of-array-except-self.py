class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        left_prod = 1
        for n in nums:
            result.append(left_prod)
            left_prod *= n
        right_prod = 1
        for i in range(len(nums)-1, -1, -1):
            result[i] *= right_prod
            right_prod *= nums[i]
        return result
