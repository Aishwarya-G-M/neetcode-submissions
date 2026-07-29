class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!elements.add(nums[i]))return true;
        }
        return false;
    }
}