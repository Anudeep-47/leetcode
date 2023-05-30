class Solution:
    def climbStairs(self, n: int) -> int:
        first, second = 1, 1
        while n>1:
            temp = first + second
            first, second = second, temp
            n -= 1
        return second