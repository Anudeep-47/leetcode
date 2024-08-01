class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # char_pos = {}
        # for pos, c in enumerate(order):
        #     char_pos[c] = pos
        # s_chars = list(s)
        # s_chars.sort(key=lambda a: char_pos.get(a,0))
        # return ''.join(s_chars)
        
        s_counts = collections.Counter(s)
        res = []
        for c in order:
            count = s_counts[c]
            s_counts[c] = 0
            res.extend([c for _ in range(count)])
        for c, count in s_counts.items():
            if count>0:
                res.extend([c for _ in range(count)])
        return ''.join(res)