class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        Map<Integer, Integer> nextGreat = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stk.isEmpty() && nums2[i]>=stk.peek()){
                stk.pop();
            }
            nextGreat.put(nums2[i], stk.isEmpty() ? -1 : stk.peek());
            stk.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = nextGreat.get(nums1[i]);
        }
        return res;
    }
}