class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] distances = new int[n];
        int maxDis = 0;
        int nearSeatIndex=-n;
        for(int i=0; i<n; i++){
            if(seats[i]==1){
                nearSeatIndex=i;
            }
            distances[i] = i-nearSeatIndex;
        }
        nearSeatIndex=2*n;
        for(int i=n-1; i>=0; i--){
            if(seats[i]==1){
                nearSeatIndex=i;
            }
            distances[i] = Math.min(distances[i], nearSeatIndex-i);
            maxDis = Math.max(maxDis, distances[i]);
        }
        return maxDis;
    }
}