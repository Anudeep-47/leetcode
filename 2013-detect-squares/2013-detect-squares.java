class DetectSquares {
    Map<String, Integer> points;
    List<int[]> pointList;
    public DetectSquares() {
        points = new HashMap<>();
        pointList = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String p = point[0]+", "+point[1];
        points.put(p, points.getOrDefault(p, 0)+1);
        pointList.add(point);
    }
    
    public int count(int[] point) {
        int total = 0;
        for(int[] p : pointList){
            if(Math.abs(p[0]-point[0])==0 || Math.abs(p[0]-point[0])!=Math.abs(p[1]-point[1]))continue;
            String first = p[0]+", "+point[1];
            String second = point[0]+", "+p[1];
            total += points.getOrDefault(first, 0)*points.getOrDefault(second, 0);
        }
        return total;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */