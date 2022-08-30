class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int neighbours = getNeighbourLives(board, i, j);
                if(board[i][j]==1){
                    if(neighbours==2 || neighbours==3){
                        board[i][j] = 3;
                    }
                }
                else if(neighbours==3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] >>= 1;
            }
        }
    }
    private int getNeighbourLives(int[][] board, int i, int j){
        int[] dirs = new int[]{-1, 0, 1};
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                int a = i+dirs[x];
                int b = j+dirs[y];
                if(a<0 || a>=m || b<0 || b>=n)continue;
                int val = board[a][b];
                if((val & 1)==1)count++;
            }
        }
        count -= board[i][j];
        return count;
    }
}