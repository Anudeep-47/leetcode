class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> count.get(a)-count.get(b));
        for(int n : count.keySet()){
            minHeap.add(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}