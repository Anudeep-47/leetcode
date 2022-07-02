class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max_h_cut = horizontalCuts[0];
        long max_v_cut = verticalCuts[0];
        for(int i=1; i<horizontalCuts.length; i++){
            max_h_cut = Math.max(max_h_cut, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i=1; i<verticalCuts.length; i++){
            max_v_cut = Math.max(max_v_cut, verticalCuts[i]-verticalCuts[i-1]);
        }
        max_h_cut = Math.max(max_h_cut, h-horizontalCuts[horizontalCuts.length-1]);
        max_v_cut = Math.max(max_v_cut, w-verticalCuts[verticalCuts.length-1]);
        return (int)((max_h_cut*max_v_cut)%1000000007);
    }
}