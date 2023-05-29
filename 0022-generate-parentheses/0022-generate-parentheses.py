class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        comb = []
        open_count, close_count = 0, 0
        def backtrack():
            nonlocal open_count, close_count
            if len(comb) == 2*n:
                res.append(''.join(comb))
                return
            if n > open_count:
                comb.append('(')
                open_count += 1
                backtrack()
                comb.pop()
                open_count -= 1
            if open_count > close_count:
                comb.append(')')
                close_count += 1
                backtrack()
                comb.pop()
                close_count -= 1
            return
        backtrack()
        return res
