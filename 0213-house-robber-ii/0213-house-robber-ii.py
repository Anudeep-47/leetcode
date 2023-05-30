class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        def rob_straight(money):
            first, second = 0, money[0]
            for i in range(1, len(money)):
                temp = max(first+money[i], second)
                first, second = second, temp
            return max(first, second)
        return max(rob_straight(nums[:-1]), rob_straight(nums[1:]))