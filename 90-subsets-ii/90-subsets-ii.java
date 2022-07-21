class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int resultSize = result.size();
        for(int i=0; i<nums.length; i++){
            int index = (i>0 && nums[i]==nums[i-1]) ? resultSize : 0;
            resultSize = result.size();
            for(int j=index; j<resultSize; j++){
                List<Integer> curSubset = new ArrayList<>(result.get(j));
                curSubset.add(nums[i]);
                result.add(curSubset);
            }
        }
        return result;
    }
}