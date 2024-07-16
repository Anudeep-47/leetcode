class Solution:
    def multiply(self, mat1: List[List[int]], mat2: List[List[int]]) -> List[List[int]]:
        # result = [[0]*len(mat2[0]) for _ in range(len(mat1))]
        # for row_index, row_vals in enumerate(mat1):
        #     for val_index, row_val in enumerate(row_vals):
        #         if row_val != 0:
        #             for col_index, col_val in enumerate(mat2[val_index]):
        #                 result[row_index][col_index] += row_val*col_val
        # return result

        def compress_matrix(matrix):
            rows, cols = len(matrix), len(matrix[0])
            compressed_matrix = [[] for _ in range(rows)]
            for r in range(rows):
                for c in range(cols):
                    if matrix[r][c]!=0:
                        compressed_matrix[r].append([matrix[r][c], c])
            return compressed_matrix
        
        m, k, n = len(mat1), len(mat1[0]), len(mat2[0])
        comp_mat1, comp_mat2 = compress_matrix(mat1), compress_matrix(mat2)
        result = [[0]*n for _ in range(m)]
        for r in range(m):
            for row_val, val_index in comp_mat1[r]:
                for col_val, c in comp_mat2[val_index]:
                    result[r][c] += row_val*col_val
        return result