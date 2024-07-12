class Solution:
    def anagramMappings(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums_map = defaultdict(list)
        for i, n in enumerate(nums2):
            nums_map[n].append(i)
        result = []
        for n in nums1:
            result.append(nums_map[n][-1])
            nums_map[n].pop()
        return result