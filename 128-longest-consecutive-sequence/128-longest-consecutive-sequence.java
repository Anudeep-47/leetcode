class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Set<Integer> map = new HashSet<Integer>();
        for(int n : nums){
            map.add(n);
        }
        int maxLength = 1;
        for(int n : nums){
            if(!map.contains(n-1)){
                int seqCount = 1;
                int seqNum = n+1;
                while(map.contains(seqNum)){
                    seqCount++;
                    seqNum++;
                }
                maxLength = Math.max(maxLength, seqCount);
            }
        }
        return maxLength;
    }
}