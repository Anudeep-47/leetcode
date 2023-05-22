from collections import Counter

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)
        unique = list(count.keys())
        n = len(unique)
        
        def partition(left, right, pivot_index) -> int:
            pivot_frequency = count[unique[pivot_index]]
            unique[pivot_index], unique[right] = unique[right], unique[pivot_index]
            store_index = left
            for i in range(left, right):
                if count[unique[i]] > pivot_frequency:
                    unique[store_index], unique[i] = unique[i], unique[store_index]
                    store_index += 1
            unique[store_index], unique[right] = unique[right], unique[store_index]
            return store_index

        def quickselect(left, right, k_position) -> None:
            if left == right:
                return
            pivot_index = random.randint(left, right)
            pivot_index = partition(left, right, pivot_index)
            if pivot_index == k_position:
                return
            elif pivot_index < k_position:
                quickselect(pivot_index+1, right, k_position)
            else:
                quickselect(left, pivot_index-1, k_position)
            return

        quickselect(0, n-1, k)
        return unique[:k]