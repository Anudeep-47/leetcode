class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0, count = 0;
        for(int n : nums){
            sum += n;
            if(sumMap.containsKey(sum-k)){
                count += sumMap.get(sum-k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}