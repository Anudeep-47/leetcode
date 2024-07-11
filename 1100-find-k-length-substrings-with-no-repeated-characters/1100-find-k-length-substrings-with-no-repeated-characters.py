class Solution:
    def numKLenSubstrNoRepeats(self, s: str, k: int) -> int:
        sub_map = {}
        count = 0
        start, n = 0, len(s)
        for end in range(n):
            if s[end] in sub_map:
                next_start = sub_map[s[end]]+1
                while start<next_start:
                    del sub_map[s[start]]
                    start += 1
            sub_map[s[end]] = end
            if len(sub_map) == k:
                count += 1
                del sub_map[s[start]]
                start += 1
        return count