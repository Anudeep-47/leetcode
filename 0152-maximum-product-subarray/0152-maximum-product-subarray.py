class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        nums_min = nums_max = res
        # # method 1
        # for i in range(1, len(nums)):
        #     num = nums[i]
        #     temp_max = max(num, nums_max*num, nums_min*num)
        #     nums_min = min(num, nums_max*num, nums_min*num)
        #     nums_max = temp_max
        #     res = max(res, nums_max)
        # return res

        # method 2
        for i in range(1, len(nums)):
            num = nums[i]
            if num < 0:
                nums_max, nums_min = nums_min, nums_max
            nums_max = max(num, nums_max*num)
            nums_min = min(num, nums_min*num)
            res = max(res, nums_max)
        return res