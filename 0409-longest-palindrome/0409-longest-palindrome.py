class Solution:
    def longestPalindrome(self, s: str) -> int:
        odd, total = 0, 0
        for key, val in collections.Counter(s).most_common():
            total += val-val%2
            odd += val%2
        return total + int(odd>0)
        