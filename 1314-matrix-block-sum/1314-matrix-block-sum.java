class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = mat[i][j];
                if(i>0){
                    dp[i][j] += dp[i-1][j];
                }
                if(j>0){
                    dp[i][j] += dp[i][j-1];
                }
                if(i>0 && j>0){
                    dp[i][j] -= dp[i-1][j-1];
                }
            }
        }
        int[][] res = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int rs = Math.max(0, i-k);
                int re = Math.min(n-1, i+k);
                int cs = Math.max(0, j-k);
                int ce = Math.min(m-1, j+k);
                res[i][j] = dp[re][ce];
                if(rs>0){
                    res[i][j] -= dp[rs-1][ce];
                }
                if(cs>0){
                    res[i][j] -= dp[re][cs-1];
                }
                if(rs>0 && cs>0){
                    res[i][j] += dp[rs-1][cs-1];
                }
            }
        }
        return res;
    }
}