class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;
    
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>((a, b) -> a-b);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        int top = maxHeap.poll();
        minHeap.add(top);
        if(minHeap.size()>maxHeap.size()){
            top = minHeap.poll();
            maxHeap.add(top);
        }
    }
    
    public double findMedian() {
        double left = maxHeap.peek();
        if(maxHeap.size()==minHeap.size()){
            double right = minHeap.peek();
            left = (double)(left+right)/2;
        }
        return left;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */