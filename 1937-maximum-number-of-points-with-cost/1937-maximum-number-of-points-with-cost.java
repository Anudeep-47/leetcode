class Solution {
    public long maxPoints(int[][] points) {
        int m=points.length;
        int n=points[0].length;
        long[] cur = new long[n];
        long[] prev = new long[n];
        for(int i=0; i<m; i++){
            long maxVal = 0;
            for(int j=0; j<n; j++){
                maxVal = Math.max(maxVal-1, prev[j]);
                cur[j] = maxVal;
            }
            for(int j=n-1; j>=0; j--){
                maxVal = Math.max(maxVal-1, prev[j]);
                cur[j] = Math.max(maxVal, cur[j])+points[i][j];
            }
            long[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return Arrays.stream(prev).max().getAsLong();
    }
}