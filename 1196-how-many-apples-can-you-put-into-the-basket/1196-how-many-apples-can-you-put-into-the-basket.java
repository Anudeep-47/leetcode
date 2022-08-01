class Solution {
    public int maxNumberOfApples(int[] weight) {
        int[] weightCount = new int[1001];
        for(int w : weight){
            weightCount[w]++;
        }
        int limit=5000;
        int count=0;
        for(int i=1; i<=1000; i++){
            if(weightCount[i]>0){
                int apples = Math.min(limit/i, weightCount[i]);
                limit -= apples*i;
                count += apples;
                if(limit<i+1) return count;
            }
        }
        return count;
    }
}