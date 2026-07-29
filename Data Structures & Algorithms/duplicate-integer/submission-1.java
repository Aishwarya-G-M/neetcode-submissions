class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for(int num: nums){
            if(!elements.add(num))return true;
        }
        return false;
    }
}