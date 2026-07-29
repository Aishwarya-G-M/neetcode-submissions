class Solution {
    public int longestConsecutive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxSeqLength = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
            set.add(i);
        }

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int seq = nums[i];
                while(set.contains(seq)){
                    seq++;
                }
                maxSeqLength = Math.max(maxSeqLength, (seq-nums[i]));
            }
        }
        return maxSeqLength;
    }
}
