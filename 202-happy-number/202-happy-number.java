class Solution {
    public boolean isHappy(int n) {
        int slowNum = n;
        int fastNum = n;
        do {
            slowNum = getNextNumber(slowNum);
            fastNum = getNextNumber(getNextNumber(fastNum));
        } while(fastNum!=1 && slowNum!=fastNum);
        return fastNum==1;
    }
    private int getNextNumber(int n){
        int prod = 0;
        while(n>0){
            prod += (n%10)*(n%10);
            n /= 10;
        }
        return prod;
    }
}