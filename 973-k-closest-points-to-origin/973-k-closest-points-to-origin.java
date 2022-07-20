class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if(points.length==k)return points;
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(int i=0; i<points.length; i++){
            int sqrdDis = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            maxHeap.add(new int[]{sqrdDis, i});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int res[][] = new int[k][2];
        while(!maxHeap.isEmpty()){
            int index = maxHeap.poll()[1];
            res[--k] = points[index];
        }
        return res;
    }
}