class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Pair<Integer, String>>> userMap = new HashMap<>();
        for(int i=0; i<username.length; i++){
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair<>(timestamp[i], website[i]));
        }
        HashMap<String, Integer> patCount = new HashMap<>();
        String resPat = "";
        for(String user : userMap.keySet()){
            List<Pair<Integer, String>> list = userMap.get(user);
            Collections.sort(list, (a, b) -> a.getKey()-b.getKey());
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<list.size(); i++){
                for(int j=i+1; j<list.size(); j++){
                    for(int k=j+1; k<list.size(); k++){
                        String pat = list.get(i).getValue() + " " + list.get(j).getValue() + " " + list.get(k).getValue();
                        if(!set.contains(pat)){
                            set.add(pat);
                            patCount.put(pat, patCount.getOrDefault(pat, 0)+1);
                            if(resPat == "" || patCount.get(resPat) < patCount.get(pat) || (patCount.get(resPat) == patCount.get(pat) && resPat.compareTo(pat) > 0)) {
                                resPat = pat;
                            }
                        }
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(String str : resPat.split(" ")){
            res.add(str);
        }
        return res;
    }
}