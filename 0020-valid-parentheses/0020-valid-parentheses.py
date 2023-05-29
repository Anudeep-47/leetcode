class Solution:
    def isValid(self, s: str) -> bool:
        bracket_dict = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        stack = []
        open_brackets = bracket_dict.values()
        for char in s:
            if char in open_brackets:
                stack.append(char)
            elif len(stack)!=0 and bracket_dict[char]==stack[-1]:
                stack.pop()
            else:
                return False
        return len(stack) == 0