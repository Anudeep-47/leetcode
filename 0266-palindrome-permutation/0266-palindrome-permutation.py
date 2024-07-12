class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        counter = collections.Counter(s)
        odds = 0
        for val in counter.values():
            odds += val%2
            if odds>1:
                return False
        return True