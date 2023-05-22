class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9
        rows = [0]*n
        cols = [0]*n
        boxes = [0]*n
        for r in range(n):
            for c in range(n):
                if board[r][c] == '.':
                    continue
                pos = int(board[r][c])-1
                if rows[r] & (1 << pos):
                    return False
                rows[r] |= (1 << pos)
                if cols[c] & (1 << pos):
                    return False
                cols[c] |= (1 << pos)
                index = (r//3)*3 + (c//3)
                if boxes[index] & (1 << pos):
                    return False
                boxes[index] |= (1 << pos)
        return True