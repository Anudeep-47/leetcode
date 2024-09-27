class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n { static_cast<int>(nums.size())};
        int sum {};
        for(int n : nums) sum += n;
        return n*(n+1)/2 - sum;
    }
};