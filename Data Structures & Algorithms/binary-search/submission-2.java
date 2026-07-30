class Solution {
    public int search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    private int search(int[] nums,int target,int left,int right){
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]==target)return mid;
            if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
