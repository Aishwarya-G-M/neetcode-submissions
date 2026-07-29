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

        for(int i=min;i<=max;i++){
            int tempSeqLength = 0;
            while(set.contains(i)){
                tempSeqLength++;
                i++;
            }
            maxSeqLength = Math.max(maxSeqLength,tempSeqLength);
        }
        return maxSeqLength;
    }
}
