class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] dis = new int[n+1][3];
        dis[n][0] = -1;
        dis[n][1] = -1;
        dis[n][2] = -1;
        for(int i=n-1; i>=0; i--){
            dis[n][colors[i]-1] = i;
            dis[i][0] = dis[n][0];
            dis[i][1] = dis[n][1];
            dis[i][2] = dis[n][2];
        }
        for(int i=1; i<n; i++){
            dis[n][colors[i]-1] = i;
            if(dis[i][0]==-1 || i-dis[n][0] < dis[i][0]-i) dis[i][0] = dis[n][0];
            if(dis[i][1]==-1 || i-dis[n][1] < dis[i][1]-i) dis[i][1] = dis[n][1];
            if(dis[i][2]==-1 || i-dis[n][2] < dis[i][2]-i) dis[i][2] = dis[n][2];
        }
        List<Integer> res = new ArrayList<>();
        for(int[] q : queries){
            res.add(dis[q[0]][q[1]-1]!=-1 ? Math.abs(dis[q[0]][q[1]-1]-q[0]) : -1);
        }
        return res;
    }
}