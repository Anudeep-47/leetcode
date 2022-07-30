class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0; i<m; i++){
            sortDiagonal(i, 0, mat);
        }
        for(int i=1; i<n; i++){
            sortDiagonal(0, i, mat);
        }
        return mat;
    }
    
    private void sortDiagonal(int row, int col, int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int diagLen = Math.min(m-row, n-col);
        List<Integer> diagonal = new ArrayList<>();
        for(int i=0; i<diagLen; i++){
            diagonal.add(mat[row+i][col+i]);
        }
        diagonal = countingSort(diagonal);
        for(int i=0; i<diagLen; i++){
            mat[row+i][col+i] = diagonal.remove(0);
        }
    }
    
    private List<Integer> countingSort(List<Integer> diagList){
        int minVal = Collections.min(diagList);
        int maxVal = Collections.max(diagList);
        int rangeLen = maxVal-minVal+1;
        int[] counts = new int[rangeLen];
        for(int num : diagList){
            counts[num-minVal]++;
        }
        List<Integer> sortedDiagList = new ArrayList<>();
        for(int i=0; i<counts.length; i++){
            while(counts[i]>0){
                sortedDiagList.add(i+minVal);
                counts[i]--;
            }
        }
        return sortedDiagList;
    }
}