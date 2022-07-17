class Solution {
    public int getMaxLen(int[] nums) {
        int posLen = 0;
        int negLen = 0;
        int res = 0;
        for(int n : nums){
            if(n == 0){
                posLen = 0;
                negLen = 0;
            }
            else if(n > 0){
                posLen++;
                negLen = negLen == 0 ? 0 : negLen + 1;
            }
            else {
                int temp = posLen;
                posLen = negLen == 0 ? 0 : negLen + 1;
                negLen = temp + 1;
            }
            res = Math.max(res, posLen);
        }
        return res;
    }
}