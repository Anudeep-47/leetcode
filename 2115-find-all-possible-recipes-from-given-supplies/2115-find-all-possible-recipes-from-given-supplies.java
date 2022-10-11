class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> ingToRec = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(int i=0; i<recipes.length; i++){
            indegree.put(recipes[i], ingredients.get(i).size());
            for(String ing : ingredients.get(i)){
                ingToRec.putIfAbsent(ing, new ArrayList<>());
                ingToRec.get(ing).add(recipes[i]);
            }
        }
        List<String> res = new ArrayList<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for(String sup : supplies){
            queue.offer(sup);
        }
        while(!queue.isEmpty()){
            String item = queue.poll();
            if(!ingToRec.containsKey(item))continue;
            for(String rec : ingToRec.get(item)){
                indegree.put(rec, indegree.get(rec)-1);
                if(indegree.get(rec)==0){
                    queue.offer(rec);
                    res.add(rec);
                }
            }
        }
        return res;
    }
}