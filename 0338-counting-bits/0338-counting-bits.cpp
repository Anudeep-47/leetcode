class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> res(n+1);
        for (int x=1; x<=n; x++) {
            res[x] = res[x & (x-1)] + 1;
        }
        return res;
    }
};