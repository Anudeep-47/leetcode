class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        boolean visited[][][] = new boolean[m][n][k+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0; j<size; j++){
                int[] top = queue.poll();
                int x=top[0], y=top[1], nextk=top[2];
                if(x==m-1 && y==n-1) return count;
                for(int i=0; i<4; i++){
                    int r=x+dirs[i], c=y+dirs[i+1];
                    if(r<0 || r>=m || c<0 || c>=n || (nextk+grid[r][c])>k || visited[r][c][nextk+grid[r][c]])continue;
                    queue.offer(new int[]{r, c, nextk+grid[r][c]});
                    visited[r][c][nextk+grid[r][c]] = true;
                }
            }
            count++;
        }
        return -1;
    }
}