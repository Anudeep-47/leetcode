from collections import Counter

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n, m = len(s), len(p)
        if n < m:
            return []
        p_count = Counter(p)
        s_count = Counter()
        result = []
        for i in range(n):
            s_count[s[i]] += 1
            if i >= m:
                if s_count[s[i-m]] == 1:
                    del s_count[s[i-m]]
                else:
                    s_count[s[i-m]] -= 1
            if p_count == s_count:
                result.append(i-m+1)
        return result