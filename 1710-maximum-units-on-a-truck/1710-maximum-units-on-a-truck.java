class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        int total=0;
        int i=0;
        while(i<boxTypes.length && truckSize>0){
            total += boxTypes[i][1]*Math.min(boxTypes[i][0], truckSize);
            truckSize = Math.max(truckSize-boxTypes[i][0], 0);
            i++;
        }
        return total;
    }
}