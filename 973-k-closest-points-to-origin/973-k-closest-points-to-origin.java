class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int low = 0;
        int high = points.length-1;
        int pivotIndex = points.length;
        while(pivotIndex!=k){
            pivotIndex = partition(points, low, high);
            if(pivotIndex<k){
                low = pivotIndex;
            }
            else{
                high = pivotIndex-1;
            }
        }
        return Arrays.copyOf(points, k);
    }
    
    private int partition(int[][] points, int low, int high){
        int[] pivotPoint = points[low+(high-low)/2];
        int pivotDis = sqrdDis(pivotPoint);
        while(low<high){
            if(sqrdDis(points[low])>=pivotDis){
                int[] temp = points[low];
                points[low] = points[high];
                points[high] = temp;
                high--;
            }
            else {
                low++;
            }
        }
        if(sqrdDis(points[low])<pivotDis){
            low++;
        }
        return low;
    }
    
    private int sqrdDis(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
    
}