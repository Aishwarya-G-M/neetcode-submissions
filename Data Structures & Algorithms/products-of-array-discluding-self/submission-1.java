class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLength = nums.length;
        int[] product = new int[arrLength];
        product[0] = 1;
        int rightProduct = 1;
        for(int i=1;i<arrLength;i++){
            product[i] = nums[i-1]*product[i-1];
        }

        for(int i=arrLength-2;i>=0;i--){
            rightProduct = nums[i+1]*rightProduct;
            product[i] = rightProduct*product[i];
        }
        return product;
    }
}  
