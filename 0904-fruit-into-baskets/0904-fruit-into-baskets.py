class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter = collections.Counter()
        max_trees, start = 0, 0
        for end, fruit in enumerate(fruits):
            counter[fruit] += 1
            while len(counter) > 2:
                counter[fruits[start]] -= 1
                if counter[fruits[start]] == 0:
                    del counter[fruits[start]]
                start += 1
            max_trees = max(max_trees, end-start+1)
        return max_trees