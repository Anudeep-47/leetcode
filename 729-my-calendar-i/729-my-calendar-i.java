class MyCalendar {
    TreeMap<Integer, Integer> cal;
    public MyCalendar() {
        cal = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = cal.floorKey(start);
        Integer nextStart = cal.ceilingKey(start);
        if(prevStart!=null && start<cal.get(prevStart) || nextStart!=null && nextStart<end) return false;
        cal.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */