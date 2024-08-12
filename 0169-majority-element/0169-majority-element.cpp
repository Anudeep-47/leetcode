class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majority {}, count {};
        for (int n : nums) {
            if (count == 0) {
                majority = n;
            }
            count += majority==n ? 1 : -1;
        }
        return majority;
    }
};