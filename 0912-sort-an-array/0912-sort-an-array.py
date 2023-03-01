class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        count_nums = [0]*(10**5+1)
        offset = 5*10**4
        for n in nums:
            count_nums[n+offset] += 1
        res = [i-offset for i, count in enumerate(count_nums) for _ in range(count)]
        return res