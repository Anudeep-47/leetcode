class Solution:
    def trap(self, height: List[int]) -> int:
        # # monotonic stack solution
        # stack = []
        # total_water = 0
        # for i in range(len(height)):
        #     while stack and height[stack[-1]] < height[i]:
        #         bottom = stack.pop()
        #         if not stack:
        #             break
        #         distance = i-stack[-1]-1
        #         min_height = min(height[stack[-1]], height[i])-height[bottom]
        #         total_water += distance * min_height
        #     stack.append(i)
        # return total_water

        # two pointers solution
        total_water = 0
        max_left, max_right = 0, 0
        left, right = 0, len(height)-1
        while left<right:
            if height[left]<height[right]:
                if height[left]>=max_left:
                    max_left = height[left]
                else:
                    total_water += max_left-height[left]
                left += 1
            else:
                if height[right]>=max_right:
                    max_right = height[right]
                else:
                    total_water += max_right-height[right]
                right -= 1
        return total_water
        
            