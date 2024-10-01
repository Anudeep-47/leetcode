class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int i {};
        int j { static_cast<int>(nums.size()-1)};
        vector<int> res(nums.size());
        int k { j };
        while (i<=j) {
            if (nums[i]*nums[i] < nums[j]*nums[j]) {
                res[k--] = nums[j]*nums[j--];
            }
            else {
                res[k--] = nums[i]*nums[i++];
            }
        }
        return res;
    }
};