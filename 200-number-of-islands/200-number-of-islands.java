class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int r, int c){
        int m = grid.length, n = grid[0].length;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        grid[r][c] = '0';
        queue.offer(new int[]{r, c});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int nr = cur[0]+dirs[i];
                int nc = cur[1]+dirs[i+1];
                if(nr<0 || nr>=m || nc<0 || nc>=n || grid[nr][nc]!='1')continue;
                grid[nr][nc] = '0';
                queue.offer(new int[]{nr, nc});
            }
        }
        return;
    }
}