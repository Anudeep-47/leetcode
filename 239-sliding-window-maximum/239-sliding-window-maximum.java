class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int[] res = new int[nums.length-k+1];
        int start=0;
        for(int end=start; end<nums.length; end++){
            if(!indexMap.containsKey(nums[end])){
                maxHeap.add(nums[end]);
            }
            indexMap.put(nums[end], end);
            if(end-start+1==k){
                while(indexMap.get(maxHeap.peek()) < start){
                    int top = maxHeap.poll();
                    indexMap.remove(top);
                }
                res[end-k+1] = maxHeap.peek();
                start++;
            }
        }
        return res;
    }
}