class StockPrice {
    Map<Integer, Integer> timeToPrice;
    int currentTime;
    PriorityQueue<int[]> minHeap;
    PriorityQueue<int[]> maxHeap;
    
    public StockPrice() {
        timeToPrice = new HashMap<>();
        currentTime = 0;
        minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
    }
    
    public void update(int timestamp, int price) {
        timeToPrice.put(timestamp, price);
        if(currentTime < timestamp)currentTime = timestamp;
        minHeap.add(new int[]{price, timestamp});
        maxHeap.add(new int[]{price, timestamp});
    }
    
    public int current() {
        return timeToPrice.get(currentTime);
    }
    
    public int maximum() {
        while(!maxHeap.isEmpty() && maxHeap.peek()[0]!=timeToPrice.get(maxHeap.peek()[1])){
            maxHeap.poll();
        }
        return maxHeap.peek()[0];
    }
    
    public int minimum() {
        while(!minHeap.isEmpty() && minHeap.peek()[0]!=timeToPrice.get(minHeap.peek()[1])){
            minHeap.poll();
        }
        return minHeap.peek()[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */