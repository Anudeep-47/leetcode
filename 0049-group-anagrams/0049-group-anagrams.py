from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        for s in strs:
            counts = [0]*26
            for c in s:
                counts[ord(c)-ord('a')] += 1
            result[tuple(counts)].append(s)
        return result.values()