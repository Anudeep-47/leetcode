class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean up=false, down=false, left=false, right=false;
        int rowStart=0, rowEnd=matrix.length-1;
        int colStart=0, colEnd=matrix[0].length-1;
        int row=0, col=0;
        List<Integer> res = new ArrayList<>();
        int totalCount = matrix.length*matrix[0].length;
        right=true;
        while(totalCount>0){
            res.add(matrix[row][col]);
            totalCount--;
            if(right){
                if(col==colEnd){
                    right=false;
                    down=true;
                    rowStart++;
                    row++;
                }
                else col++;
            }
            else if(down){
                if(row==rowEnd){
                    down=false;
                    left=true;
                    colEnd--;
                    col--;
                }
                else row++;
            }
            else if(left){
                if(col==colStart){
                    left=false;
                    up=true;
                    rowEnd--;
                    row--;
                }
                else col--;
            }
            else if(up){
                if(row==rowStart){
                    up=false;
                    right=true;
                    colStart++;
                    col++;
                }
                else row--;
            }
        }
        return res;
    }
}