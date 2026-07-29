class Solution {
    public int trap(int[] height) {
        int maxArea = 0;
        int h = height.length;
        // max level to the left of each height level
        int[] lMaxLevels = new int[h];
        lMaxLevels[0] = height[0];
        for(int i=1;i<h;i++){
            lMaxLevels[i] = Math.max(lMaxLevels[i-1],height[i]);
        }

        // max level to the right of each height level
        int[] rMaxLevels = new int[h];
        rMaxLevels[h-1] = height[h-1];
        for(int i=h-2;i>=0;i--){
            rMaxLevels[i] = Math.max(rMaxLevels[i+1],height[i]);
        }
        
        for(int i=0;i<h;i++){
            maxArea += Math.min(lMaxLevels[i],rMaxLevels[i])-(height[i]);
        }
        return maxArea;
    }
}
