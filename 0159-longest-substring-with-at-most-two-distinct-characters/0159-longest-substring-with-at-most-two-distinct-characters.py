class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        # O(n) time & O(1) space
        at_most = 2
        max_sub = float('-inf')
        start, n = 0, len(s)
        sub_map = defaultdict(int)
        for end in range(n):
            sub_map[s[end]] += 1
            while len(sub_map) > at_most:
                sub_map[s[start]] -= 1
                if sub_map[s[start]] == 0:
                    del sub_map[s[start]]
                start += 1
            max_sub = max(max_sub, end-start+1)
        return max_sub