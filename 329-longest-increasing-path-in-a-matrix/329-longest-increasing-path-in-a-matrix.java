class Solution {
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int maxLen = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxLen = Math.max(maxLen, dfsIncreasingPath(matrix, i, j, cache));
            }
        }
        return maxLen;
    }
    private int dfsIncreasingPath(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j]>0)return cache[i][j];
        for(int[] dir : dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(0<=ni && ni<m && 0<=nj && nj<n && matrix[i][j]<matrix[ni][nj]){
                cache[i][j] = Math.max(cache[i][j], dfsIncreasingPath(matrix, ni, nj, cache));
            }
        }
        cache[i][j]++;
        return cache[i][j];
    }
}