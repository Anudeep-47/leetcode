class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        counter = collections.Counter()
        m, n = len(mat), len(mat[0])
        for i in range(m):
            for j in range(n):
                counter[mat[i][j]] += 1
                if counter[mat[i][j]] == m:
                    return mat[i][j]
        return -1