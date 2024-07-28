class Solution:
    def canAliceWin(self, nums: List[int]) -> bool:
        single_sum, double_sum = 0, 0
        for n in nums:
            if n//10:
                double_sum += n
            else:
                single_sum += n
        return single_sum != double_sum