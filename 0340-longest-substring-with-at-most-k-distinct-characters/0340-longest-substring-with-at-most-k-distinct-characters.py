class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        # O(n) time & O(k) space

        # max_sub = float('-inf')
        # start, n = 0, len(s)
        # sub_map = defaultdict(int)
        # for end in range(n):
        #     sub_map[s[end]] += 1
        #     while len(sub_map)>k:
        #         sub_map[s[start]] -= 1
        #         if sub_map[s[start]] == 0:
        #             del sub_map[s[start]]
        #         start += 1
        #     max_sub = max(max_sub, end-start+1)
        # return max_sub

        max_sub = 0
        counter = collections.Counter()
        for end in range(len(s)):
            counter[s[end]] += 1
            if len(counter) > k:
                counter[s[end-max_sub]] -= 1
                if counter[s[end-max_sub]] == 0:
                    del counter[s[end-max_sub]]
            else:
                max_sub += 1
        return max_sub