class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        n1, n2, n3 = len(arr1), len(arr2), len(arr3)
        res = []
        i, j, k = 0, 0, 0
        while i<n1 and j<n2 and k<n3:
            if arr1[i] == arr2[j] == arr3[k]:
                res.append(arr1[i])
                i, j, k = i+1, j+1, k+1
            else:
                _, arr_id = min([(arr1[i], 0), (arr2[j], 1), (arr3[k], 2)], key=lambda a: a[0])
                if arr_id < 1:
                    i += 1
                elif arr_id > 1:
                    k += 1
                else:
                    j += 1
        return res