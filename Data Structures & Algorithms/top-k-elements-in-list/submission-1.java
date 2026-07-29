class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i : nums){
            if(!frequencyMap.containsKey(i)){
                frequencyMap.put(i,1);
            }else{
                frequencyMap.put(i,frequencyMap.get(i)+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            System.out.println("Key = "+entry.getKey()+" "+" Value = "+entry.getValue());
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            if(maxHeap.size()<k){
                maxHeap.offer(entry);
            }else{
                if(maxHeap.peek().getValue()<entry.getValue()){
                    maxHeap.poll();
                    maxHeap.offer(entry);
                }
            }
        }

        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }
}
