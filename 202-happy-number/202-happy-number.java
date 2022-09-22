class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n))return false;
            set.add(n);
            n = getNextNumber(n);
        }
        return true;
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