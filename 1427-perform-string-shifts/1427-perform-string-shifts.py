class Solution:
    def stringShift(self, s: str, shift: List[List[int]]) -> str:
        k = 0
        for _dir, amount in shift:
            k += -amount if _dir else amount
        k = k%len(s) if k>0 else -(-k%len(s))
        return s[k:]+s[:k]