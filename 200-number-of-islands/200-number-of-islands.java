class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int lands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    Queue<int[]> gridQueue = new ArrayDeque<>();
                    lands++;
                    grid[i][j] = '0';
                    gridQueue.add(new int[]{i, j});
                    while(!gridQueue.isEmpty()){
                        int[] rc = gridQueue.poll();
                        int r=rc[0], c=rc[1];
                        if(r+1<m && grid[r+1][c]=='1'){
                            gridQueue.add(new int[]{r+1, c});
                            grid[r+1][c] = '0';
                        }
                        if(r>0 && grid[r-1][c]=='1'){
                            gridQueue.add(new int[]{r-1, c});
                            grid[r-1][c] = '0';
                        }
                        if(c+1<n && grid[r][c+1]=='1'){
                            gridQueue.add(new int[]{r, c+1});
                            grid[r][c+1] = '0';
                        }
                        if(c>0 && grid[r][c-1]=='1'){
                            gridQueue.add(new int[]{r, c-1});
                            grid[r][c-1] = '0';
                        }
                    }
                }
            }
        }
        return lands;
    }
}