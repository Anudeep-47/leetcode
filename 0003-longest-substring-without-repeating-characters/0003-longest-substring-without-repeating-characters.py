class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len, left = 0, 0
        char_pos = {}
        for right, val in enumerate(s):
            if val in char_pos:
                left = max(left, char_pos[val]+1)
            char_pos[val] = right
            max_len = max(max_len, right-left+1)
        return max_len
