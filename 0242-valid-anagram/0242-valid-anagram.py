class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_count = {}
        for c in s:
            char_count[c] = char_count.get(c, 0) + 1
        for c in t:
            if c in char_count:
                char_count[c] -= 1
                if char_count[c] == 0:
                    char_count.pop(c)
            else:
                return False
        return len(char_count) == 0