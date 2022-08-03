class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, LinkedList<Integer>> anagramMap = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            anagramMap.putIfAbsent(nums2[i], new LinkedList<>());
            anagramMap.get(nums2[i]).add(i);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = anagramMap.get(nums1[i]).removeLast();
        }
        return res;
    }
}