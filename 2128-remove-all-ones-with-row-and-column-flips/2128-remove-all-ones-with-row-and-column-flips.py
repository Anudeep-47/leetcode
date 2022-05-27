class Solution:
    def removeOnes(self, grid: List[List[int]]) -> bool:
        original = grid[0]
        inverted = [1-g for g in grid[0]]
        for row in grid:
            if row != original and row != inverted:
                return False
        return True