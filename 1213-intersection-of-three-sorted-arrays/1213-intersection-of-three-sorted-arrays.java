class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            int val = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
            if(val==arr1[i]&&val==arr2[j]&&val==arr3[k]){
                res.add(val);
            }
            if(val==arr1[i])i++;
            if(val==arr2[j])j++;
            if(val==arr3[k])k++;
        }
        return res;
    }
}