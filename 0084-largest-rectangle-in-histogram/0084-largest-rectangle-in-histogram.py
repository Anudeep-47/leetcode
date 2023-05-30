class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0
        stack = [-1]
        heights.append(0)
        for i in range(len(heights)):
            while stack[-1]!=-1 and heights[stack[-1]]>heights[i]:
                cur_height = heights[stack.pop()]
                cur_width = i-stack[-1]-1
                max_area = max(max_area, cur_height*cur_width)
            stack.append(i)
        heights.pop()
        return max_area