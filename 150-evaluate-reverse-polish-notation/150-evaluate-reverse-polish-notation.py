class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for val in tokens:
            if val in ['+','-','*','/']:
                num2 = stack.pop()
                num1 = stack.pop()
                if val == '+':
                    stack.append(num1+num2)
                elif val == '-':
                    stack.append(num1-num2)
                elif val == '*':
                    sign = (-1 if num1<0 else 1) * (-1 if num2<0 else 1)
                    stack.append(abs(num1)*abs(num2)*sign)
                else:
                    sign = (-1 if num1<0 else 1) * (-1 if num2<0 else 1)
                    stack.append(abs(num1)//abs(num2)*sign)
            else:
                stack.append(int(val))
        return stack.pop()