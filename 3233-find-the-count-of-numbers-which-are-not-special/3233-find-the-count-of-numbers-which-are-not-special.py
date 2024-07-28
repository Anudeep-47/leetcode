class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        result = r-l+1
        end = int(math.sqrt(r))
        sieve = [0]*(end+1)
        p_divisors = 0
        i = 2
        while i<=end:
            if sieve[i] == 0:
                if l <= i*i <= r:
                    p_divisors += 1
                j = i
                while i*j <= end:
                    sieve[i*j] = 1
                    j += 1
            i += 1
        return result - p_divisors