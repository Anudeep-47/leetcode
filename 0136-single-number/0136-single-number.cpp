class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int num {};
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }
};