class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLength = nums.length;
        int[] productLtoR = new int[arrLength];
        int[] productRtoL = new int[arrLength];
        productLtoR[0] = 1;
        productRtoL[arrLength-1] = 1;

        for(int i=1;i<arrLength;i++){
            productLtoR[i] = nums[i-1]*productLtoR[i-1];
        }

        for(int i=arrLength-2;i>=0;i--){
            productRtoL[i] = nums[i+1]*productRtoL[i+1];
        }

        for(int i=0;i<arrLength;i++){
            productLtoR[i] = productLtoR[i]*productRtoL[i];
        }
        return productLtoR;
    }
}  
