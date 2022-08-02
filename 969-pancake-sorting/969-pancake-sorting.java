class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int val=arr.length; val>=0; val--){
            int index = find(arr, val);
            if(index == val-1) continue;
            if(index!=0){
                res.add(index+1);
                flip(arr, index+1);
            }
            res.add(val);
            flip(arr, val);
        }
        return res;
    }
    private int find(int[] arr, int val){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==val)return i;
        }
        return -1;
    }
    private void flip(int[] arr, int k){
        for(int i=0; i<k/2; i++){
            int temp = arr[i];
            arr[i] = arr[k-i-1];
            arr[k-i-1] = temp;
        }
        return;
    }
}