from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        count_t = Counter(t)
        count_s = Counter()
        matches = 0
        f_s = [(i, c) for i, c in enumerate(s) if c in count_t]
        result = float('inf'), None, None
        left, right = 0, 0
        while right < len(f_s):
            r_index, r_char = f_s[right][0], f_s[right][1]
            count_s[r_char] += 1
            if count_s[r_char] == count_t[r_char]:
                matches += 1
            while left <= right and matches == len(count_t):
                l_index, l_char = f_s[left][0], f_s[left][1]
                if result[0] > r_index-l_index+1:
                    result = r_index-l_index+1, l_index, r_index
                count_s[l_char] -= 1
                if count_s[l_char] < count_t[l_char]:
                    matches -= 1
                left += 1
            right += 1
        return "" if result[0]==float('inf') else s[result[1]:result[2]+1]
