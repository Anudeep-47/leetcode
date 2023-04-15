class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operations = {
            '+': lambda a, b: a+b,
            '-': lambda a, b: a-b,
            '*': lambda a, b: a*b,
            '/': lambda a, b: int(a/b)
        }
        stack = []
        for token in tokens:
            if token in operations:
                operand2 = stack.pop()
                operand1 = stack.pop()
                operand = operations[token](operand1, operand2)
                stack.append(operand)
            else:
                stack.append(int(token))
        return stack.pop()