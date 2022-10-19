class Solution {
    class UnionFind {
        Map<Integer, Integer> uf;
        int size;
        UnionFind(int n) {
            size = n;
            uf = new HashMap<>();
            for(int i=0; i<n; i++){
                uf.put(i, i);
            }
        }
        int find(int x){
            if(uf.get(x)!=x){
                return find(uf.get(x));
            }
            return x;
        }
        boolean union(int a, int b){
            a = find(a);
            b = find(b);
            if(a!=b){
                uf.put(b, a);
                return true;
            }
            return false;
        }
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> a[0]-b[0]);
        UnionFind uf = new UnionFind(n);
        for(int[] log : logs){
            if(uf.union(log[1], log[2])){
                n--;
            }
            if(n==1)return log[0];
        }
        return -1;
    }
}