class Solution:
    def confusingNumber(self, n: int) -> bool:
        reverse_nums = {0:0, 1:1, 6:9, 8:8, 9:6}
        new_n, old_n = 0, n
        while n>0:
            d, n = n%10, n//10
            if d not in reverse_nums:
                return False
            new_n = new_n*10 + reverse_nums[d]
        return new_n != old_n