class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjLst = new HashMap<>();
        int[] order = new int[numCourses];
        for(int[] p : prerequisites){
            int dest = p[0];
            int src = p[1];
            List<Integer> lst = adjLst.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjLst.put(src, lst);
            indegree[dest]++;
        }
        Queue<Integer> zeroQueue = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                zeroQueue.add(i);
            }
        }
        int i=0;
        while(!zeroQueue.isEmpty()){
            int node = zeroQueue.poll();
            order[i] = node;
            i++;
            for(int dest : adjLst.getOrDefault(node, new ArrayList<Integer>())){
                indegree[dest]--;
                if(indegree[dest]==0){
                    zeroQueue.add(dest);
                }
            }
        }
        if(i<numCourses){
            return new int[0];
        }
        return order;
    }
}