class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> occurenceMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String astr = new String(chars);
            occurenceMap.computeIfAbsent(astr,k -> new ArrayList<>()).add(i);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> entry : occurenceMap.entrySet()){
            List<String> groupedAnagrams = new ArrayList<>();
            List<Integer> anagramsPosition = entry.getValue();
            for(Integer position : anagramsPosition){
                groupedAnagrams.add(strs[position]);
            }
            result.add(groupedAnagrams);
        }

        return result;
    }
}
