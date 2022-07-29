class Solution {
    enum State {
        GRAY,
        BLACK
    };
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new List[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
        }
        State[] nodeStates = new State[n];
        return dfsSrcToDest(adjList, nodeStates, source, destination);
    }
    
    private boolean dfsSrcToDest(List<Integer>[] adjList, State[] nodeStates, int node, int destination){
        if(nodeStates[node]!=null){
            return nodeStates[node]==State.BLACK;
        }
        if(adjList[node].isEmpty()){
            return node == destination;
        }
        nodeStates[node] = State.GRAY;
        for(int next : adjList[node]){
            if(!dfsSrcToDest(adjList, nodeStates, next, destination)){
                return false;
            }
        }
        nodeStates[node] = State.BLACK;
        return true;
    }
}