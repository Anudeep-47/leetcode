class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int max_sum = INT_MIN, sub_sum = 0;
        for (int n : nums) {
            sub_sum = std::max(sub_sum + n, n);
            max_sum = std::max(max_sum, sub_sum);
        }
        return max_sum;
    }
};