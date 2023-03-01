class Solution:
    def fib(self, n: int) -> int:
        if n<2:
            return n
        first, second = 0, 1
        for _ in range(1, n):
            temp = first + second
            first, second = second, temp
        return second