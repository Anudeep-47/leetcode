class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # # BFS O(mn) time and space
        # m, n = len(mat), len(mat[0])
        # final_mat = [[-1]*n for _ in range(m)]
        # mat_q = deque()
        # for i in range(m):
        #     for j in range(n):
        #         if mat[i][j] == 0:
        #             final_mat[i][j] = 0
        #             mat_q.append((i, j, 0))
        # dirs = [(-1, 0), (0, -1), (0, 1), (1, 0)]
        # while len(mat_q) > 0:
        #     r, c, dis = mat_q.popleft()
        #     for x, y in dirs:
        #         i, j = r+x, c+y
        #         if 0 <= i < m and 0 <= j < n and final_mat[i][j] == -1:
        #             final_mat[i][j] = dis+1
        #             mat_q.append((i, j, dis+1))
        # return final_mat

        # DP O(mn) time and space
        m, n = len(mat), len(mat[0])
        dp = [r[:] for r in mat]
        for i in range(m):
            for j in range(n):
                if dp[i][j] != 0:
                    dp[i][j] = float('inf')
                    dp[i][j] = min(dp[i][j], dp[i][j-1]+1) if j>0 else dp[i][j]
                    dp[i][j] = min(dp[i][j], dp[i-1][j]+1) if i>0 else dp[i][j]
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if dp[i][j] != 0:
                    dp[i][j] = min(dp[i][j], dp[i][j+1]+1) if j<n-1 else dp[i][j]
                    dp[i][j] = min(dp[i][j], dp[i+1][j]+1) if i<m-1 else dp[i][j]
        return dp
                    