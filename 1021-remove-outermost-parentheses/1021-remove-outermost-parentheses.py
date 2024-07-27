class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        result = []
        layers = 0
        for p in s:
            if p == '(':
                if layers > 0:
                    result.append(p)
                layers += 1
            else:
                if layers > 1:
                    result.append(p)
                layers -= 1
        return "".join(result)