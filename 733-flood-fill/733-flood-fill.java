class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)return image;
        int m=image.length, n=image[0].length;
        int srcClr = image[sr][sc];
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        int[] dirs = new int[]{0, 1, 0, -1, 0};
        image[sr][sc] = color;
        queue.offer(new Integer[]{sr, sc});
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int r = cur[0]+dirs[i];
                int c = cur[1]+dirs[i+1];
                if(r<0 || r>=m || c<0 || c>=n || image[r][c]!=srcClr)continue;
                image[r][c] = color;
                queue.offer(new Integer[]{r, c});
            }
        }
        return image;
    }
}