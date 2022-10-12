class RangeModule {
    TreeMap<Integer, Integer> rangeMap;
    public RangeModule() {
        rangeMap = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer start = rangeMap.floorKey(left);
        Integer end = rangeMap.floorKey(right);
        if(end==null){
            rangeMap.put(left, right);
        }
        else if(start!=null && rangeMap.get(start)>=left){
            rangeMap.put(start, Math.max(rangeMap.get(end), right));
        }
        else {
            rangeMap.put(left, Math.max(rangeMap.get(end), right));
        }
        rangeMap.subMap(left, false, right, true).clear();
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = rangeMap.floorKey(left);
        if(start==null)return false;
        return rangeMap.get(start)>=right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = rangeMap.floorKey(left);
        Integer end = rangeMap.floorKey(right);
        if(end!=null && rangeMap.get(end)>right){
            rangeMap.put(right, rangeMap.get(end));
        }
        if(start!=null && rangeMap.get(start)>left){
            rangeMap.put(start, left);
        }
        rangeMap.subMap(left, true, right, false).clear();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */