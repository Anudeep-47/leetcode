class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int start=0;
        for(int end=start; end<nums.length; end++){
            while(!maxDeque.isEmpty() && maxDeque.getFirst()<start){
                maxDeque.removeFirst();
            }
            while(!maxDeque.isEmpty() && nums[maxDeque.getLast()]<nums[end]){
                maxDeque.removeLast();
            }
            maxDeque.addLast(end);
            if(end-start+1==k){
                res[end-k+1] = nums[maxDeque.getFirst()];
                start++;
            }
        }
        return res;
    }
}