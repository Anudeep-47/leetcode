class Solution {
public:
    bool isPalindrome(int x) {
        if (x<0 || x!=0 && x%10 == 0) return false;
        int m {};
        while (x>m) {
            m = m*10 + x%10;
            x /= 10;
        }
        return x == m || x == m/10;
    }
};