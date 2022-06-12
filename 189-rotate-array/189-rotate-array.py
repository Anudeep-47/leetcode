class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if k == 0:
            return
        size = len(nums)
        i = 0
        shifts = 0
        temp = nums[i]
        start = 0
        while shifts < size:
            i = (i+k)%size
            temp, nums[i] = nums[i], temp
            shifts += 1
            if i == start:
                i = (i+1)%size
                temp = nums[i]
                start = i