class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] lastInterval = result.get(result.size()-1);
            if(intervals[i][0] <= lastInterval[1]){
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
            else result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][]);
    }
}