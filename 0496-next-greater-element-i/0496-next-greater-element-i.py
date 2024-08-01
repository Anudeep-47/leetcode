class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        stack = deque()
        nums1_map = {}
        for n in nums1:
            nums1_map[n] = -1
        for n in nums2:
            while len(stack) and stack[-1] < n:
                prev_n = stack.pop()
                if prev_n in nums1_map:
                    nums1_map[prev_n] = n
            stack.append(n)
        return nums1_map.values()
        