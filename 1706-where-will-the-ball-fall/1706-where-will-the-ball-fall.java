class Solution {
    public int[] findBall(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] res = new int[n];
        for(int i=0; i<n; i++)res[i] = i;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int curCol = res[j];
                if(curCol==-1)continue;
                int nextCol = curCol+grid[i][curCol];
                if(nextCol<0 || nextCol>n-1 || grid[i][nextCol]!=grid[i][curCol]){
                    nextCol = -1;
                }
                res[j] = nextCol;
            }
        }
        return res;
    }
}