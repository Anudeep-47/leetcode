class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        row_dict, col_dict = defaultdict(int), defaultdict(int)
        m, n = len(picture), len(picture[0])
        for i in range(m):
            for j in range(n):
                if picture[i][j] == 'B':
                    row_dict[i] += 1
                    col_dict[j] += 1
        lonely = 0
        for i in range(m):
            for j in range(n):
                if picture[i][j] == 'B' and row_dict[i]==1 and col_dict[j]==1:
                    lonely += 1
        return lonely