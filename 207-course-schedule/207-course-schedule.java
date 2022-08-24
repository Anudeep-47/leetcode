class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjLst = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] p : prerequisites){
            int src = p[1];
            int des = p[0];
            adjLst.putIfAbsent(src, new ArrayList<>());
            adjLst.get(src).add(des);
            indegree[des]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int course = que.poll();
            numCourses--;
            if(!adjLst.containsKey(course))continue;
            for(int c : adjLst.get(course)){
                indegree[c]--;
                if(indegree[c]==0){
                    que.add(c);
                }
            }
        }
        return numCourses==0;
    }
}