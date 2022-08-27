class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long health = 1;
        int maxDamage = 0;
        for(int d : damage){
            health += d;
            maxDamage = Math.max(maxDamage, d);
        }
        return health - Math.min(maxDamage, armor);
    }
}