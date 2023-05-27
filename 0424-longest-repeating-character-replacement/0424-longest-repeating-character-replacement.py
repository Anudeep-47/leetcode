from collections import Counter

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        start, end = 0, 0
        count_map = Counter()
        max_count = 0
        max_len = 0
        while end<len(s):
            count_map[s[end]] += 1
            max_count = max(max_count, count_map[s[end]])
            if (end-start+1-max_count) > k:
                count_map[s[start]] -= 1
                start += 1
            max_len = end-start+1
            end += 1
        return max_len