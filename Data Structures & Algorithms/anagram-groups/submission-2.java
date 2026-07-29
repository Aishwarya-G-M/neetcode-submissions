class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> occurenceMap = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String astr = new String(chars);
            occurenceMap.computeIfAbsent(astr,k -> new ArrayList<>()).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : occurenceMap.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }
}
