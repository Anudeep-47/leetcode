class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int starts[] = new int[intervals.length];
        int ends[] = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i=0, j=0;
        int rooms=0;
        while(i<starts.length){
            if(starts[i]<ends[j]){
                rooms++;
            }
            else{
                j++;
            }
            i++;
        }
        return rooms;
    }
    
}