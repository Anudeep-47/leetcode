class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        double[] res = new double[cars.length];
        for(int i=cars.length-1; i>=0; i--){
            res[i] = -1;
            int pos = cars[i][0], speed = cars[i][1];
            while(!stack.isEmpty()){
                int j = stack.peek();
                int pos2 = cars[j][0], speed2 = cars[j][1];
                if(speed<=speed2 || (1.0*(pos2-pos)/(speed-speed2) >= res[j] && res[j]>0)){
                    stack.pop();
                }
                else break;
            }
            if(!stack.isEmpty()){
                int j = stack.peek();
                int pos2 = cars[j][0], speed2 = cars[j][1];
                res[i] = 1.0*(pos2-pos)/(speed-speed2);
            }
            stack.push(i);
        }
        return res;
    }
}