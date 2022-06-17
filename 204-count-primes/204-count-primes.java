class Solution {
    public int countPrimes(int n) {
        if(n<2)return 0;
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = 0;
        }
        arr[0] = 1;
        arr[1] = 1;
        int i = 2;
        while(i<n){
            if(arr[i] == 0){
                int j = i+i;
                while(j<n){
                    arr[j] = 1;
                    j += i;
                }
            }
            i++;
        }
        int count = 0;
        i = 0;
        while(i<n){
            if(arr[i]==0)count++;
            i++;
        }
        return count;
    }
}