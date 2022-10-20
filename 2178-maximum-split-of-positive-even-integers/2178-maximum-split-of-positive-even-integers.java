class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        LinkedList<Long> res = new LinkedList<>();
        if(finalSum%2!=0)return res;
        long n = 2;
        while(n<=finalSum){
            finalSum -= n;
            res.offer(n);
            n += 2;
        }
        res.offer(finalSum+res.pollLast());
        return res;
    }
}