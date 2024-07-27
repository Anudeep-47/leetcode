class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        char_counts = [0]*26
        for c in tiles:
            char_counts[ord(c)-ord('A')] += 1
        def dfs(counts):
            ways = 0
            for i in range(26):
                if not counts[i]:
                    continue
                counts[i] -= 1
                ways += dfs(counts) + 1
                counts[i] += 1
            return ways
        return dfs(char_counts)