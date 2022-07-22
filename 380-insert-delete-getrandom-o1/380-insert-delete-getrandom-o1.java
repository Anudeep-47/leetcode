class RandomizedSet {
    private HashMap<Integer, Integer> indexMap;
    private List<Integer> nums;
    private Random rand;
    
    public RandomizedSet() {
        indexMap = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(indexMap.containsKey(val))return false;
        indexMap.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val))return false;
        int index = indexMap.get(val);
        int lastVal = nums.get(nums.size()-1);
        nums.set(index, lastVal);
        indexMap.put(lastVal, index);
        indexMap.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */