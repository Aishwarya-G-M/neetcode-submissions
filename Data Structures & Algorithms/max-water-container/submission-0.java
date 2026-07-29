class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        while(right > left){
            int minLevel = Math.min(heights[right],heights[left]);
            int tempArea = minLevel*(right-left);
            maxArea = Math.max(tempArea,maxArea);
            if(heights[left]<heights[right]){
                left++;
                continue;
            }
            right--;
        }
        return maxArea;
    }
}
