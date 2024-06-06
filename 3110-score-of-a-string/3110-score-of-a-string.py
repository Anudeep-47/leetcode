class Solution:
    def scoreOfString(self, s: str) -> int:
        char = s[0]
        res = 0
        for c in s[1:]:
            res += abs(ord(char)-ord(c))
            char = c
        return res