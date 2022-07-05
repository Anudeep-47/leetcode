class Solution {
    public int slopeSum(int n){
        return n*(n+1)/2;
    }
    public int candy(int[] ratings) {
        if(ratings.length == 1)return 1;
        int candies = 0;
        int up=0, down=0;
        int oldSlope=0, newSlope=0;
        for(int i=1; i<ratings.length; i++){
            newSlope = ratings[i]-ratings[i-1]>0 ? 1 : (ratings[i]-ratings[i-1]<0 ? -1 : 0);
            if((oldSlope<0 && newSlope>=0) || (oldSlope>0 && newSlope==0)){
                candies += slopeSum(up) + slopeSum(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if(newSlope > 0)up++;
            else if(newSlope < 0)down++;
            else candies++;
            oldSlope = newSlope;
        }
        candies += slopeSum(up) + slopeSum(down) + Math.max(up, down) + 1;
        return candies;
    }
}