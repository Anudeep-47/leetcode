class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            int[] prev = res.get(res.size()-1);
            if(prev[1]>=cur[0]){
                prev[1] = Math.max(prev[1], cur[1]);
            }
            else res.add(cur);
        }
        return res.toArray(new int[res.size()][2]);
    }
}