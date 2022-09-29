class Solution {
    // jump line solution O(m+n)
    public int[] amountPainted(int[][] paint) {
        int[] line = new int[50001];
        int[] res = new int[paint.length];
        for(int i=0; i<paint.length; i++){
            int start = paint[i][0];
            int end = paint[i][1];
            int amount = 0;
            while(start < end){
                int jump = Math.max(start+1, line[start]);
                amount += line[start] == 0 ? 1 : 0;
                line[start] = Math.max(line[start], end);
                start = jump;
            }
            res[i] = amount;
        }
        return res;
    }
    
    // // merge intervals with treemap O(nlogn)
    // public int[] amountPainted(int[][] paint){
    //     TreeMap<Integer, Integer> intervals = new TreeMap<>();
    //     int[] res = new int[paint.length];
    //     for(int i=0; i<paint.length; i++){
    //         int[] cur = paint[i];
    //         int start = cur[0];
    //         int end = cur[1];
    //         int amount = end-start;
    //         Map.Entry<Integer, Integer> floor = intervals.floorEntry(cur[0]);
    //         if(floor!=null){
    //             if(floor.getValue()>=end)continue;
    //             if(floor.getValue()>=start){
    //                 amount -= floor.getValue()-start;
    //                 intervals.remove(floor.getKey());
    //                 start = floor.getKey();
    //             }
    //         }
    //         Map.Entry<Integer, Integer> ceil = intervals.ceilingEntry(cur[0]);
    //         while(ceil!=null && ceil.getKey()<=end){
    //             amount -= Math.min(end, ceil.getValue())-ceil.getKey();
    //             intervals.remove(ceil.getKey());
    //             end = Math.max(end, ceil.getValue());
    //             ceil = intervals.ceilingEntry(cur[0]);
    //         }
    //         intervals.put(start, end);
    //         res[i] = amount;
    //     }
    //     return res;
    // }
}