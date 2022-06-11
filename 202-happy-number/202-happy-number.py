class Solution:
    def isHappy(self, n: int) -> bool:
        def sum_square(num):
            num_sum = 0
            while num!=0:
                num_sum += (num%10)**2
                num = num//10
            return num_sum
        visited = set()
        while n != 1:
            if n in visited:
                return False
            else:
                visited.add(n)
                n = sum_square(n)
        return True
        