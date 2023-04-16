class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # monotonic stack solution
        
        # stack = []
        # answer = [0]*len(temperatures)
        # for i in range(len(temperatures)):
        #     while stack and temperatures[stack[-1]] < temperatures[i]:
        #         index = stack.pop()
        #         answer[index] = i-index
        #     stack.append(i)
        # return answer

        # array based solution O(1) space

        n = len(temperatures)
        answer = [0]*n
        highest = 0
        for i in range(n-1, -1, -1):
            cur_temp = temperatures[i]
            if cur_temp >= highest:
                highest = cur_temp
            else:
                days = 1
                while temperatures[i+days]<=cur_temp:
                    days += answer[i+days]
                answer[i] = days
        return answer
            