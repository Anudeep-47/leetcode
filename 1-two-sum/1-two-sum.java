class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> firstNums = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(firstNums.containsKey(target-nums[i])){
                return new int[]{firstNums.get(target-nums[i]), i};
            }
            else {
                firstNums.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}