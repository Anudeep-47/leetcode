class Solution:
    def tribonacci(self, n: int) -> int:
        if n<2:
            return n
        first, second, third = 0, 1, 1
        while n>2:
            temp = first + second + third
            first, second, third = second, third, temp
            n -= 1
        return third