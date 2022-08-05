class Solution {
    public boolean isArmstrong(int n) {
        int k=0;
        int num = n;
        while(n>0){
            k++;
            n /= 10;
        }
        n = num;
        int prodSum = 0;
        while(num>0){
            int lastDigit = num%10;
            prodSum += Math.pow(lastDigit, k);
            num /= 10;
        }
        return prodSum==n;
    }
}