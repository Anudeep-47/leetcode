class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        long sum = 0;
        int n = nums.length;
        for(int i=0; i<=n; i++){
            while(!stk.empty() && nums[stk.peek()] < (i==n?Integer.MAX_VALUE:nums[i])) {
                int j = stk.pop();
                int k = stk.empty() ? -1 : stk.peek();
                sum += (long)nums[j]*((j-k)*(i-j));
            }
            stk.push(i);
        }
        stk.clear();
        for(int i=0; i<=n; i++){
            while(!stk.empty() && nums[stk.peek()] > (i==n?Integer.MIN_VALUE:nums[i])) {
                int j = stk.pop();
                int k = stk.empty() ? -1 : stk.peek();
                sum -= (long)nums[j]*((j-k)*(i-j));
            }
            stk.push(i);
        }
        return sum;
    }
}