class Solution:
    def candyCrush(self, board: List[List[int]]) -> List[List[int]]:
        m, n = len(board), len(board[0])

        def find_and_crush():
            crushed = False
            for r in range(m):
                for c in range(1, n-1):
                    if board[r][c] == 0:
                        continue
                    if abs(board[r][c-1]) == abs(board[r][c]) == abs(board[r][c+1]):
                        board[r][c-1] = -(abs(board[r][c]))
                        board[r][c] = -(abs(board[r][c]))
                        board[r][c+1] = -(abs(board[r][c]))
                        crushed = True
            
            for r in range(1, m-1):
                for c in range(n):
                    if board[r][c] == 0:
                        continue
                    if abs(board[r-1][c]) == abs(board[r][c]) == abs(board[r+1][c]):
                        board[r-1][c] = -(abs(board[r][c]))
                        board[r][c] = -(abs(board[r][c]))
                        board[r+1][c] = -(abs(board[r][c]))
                        crushed = True
            
            for r in range(m):
                for c in range(n):
                    board[r][c] = 0 if board[r][c] < 0 else board[r][c]
                    
            return crushed

        def drop():
            for c in range(n):
                zero_index = -1
                for r in range(m-1, -1, -1):
                    if board[r][c]==0 and zero_index == -1:
                        zero_index = r
                    elif board[r][c]!=0 and zero_index >= 0:
                        board[zero_index][c], board[r][c] = board[r][c], board[zero_index][c]
                        zero_index -= 1
        
        while find_and_crush():
            drop()
        
        return board


            