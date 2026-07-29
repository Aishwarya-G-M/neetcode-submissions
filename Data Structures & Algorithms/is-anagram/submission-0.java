class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;

        
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(frequencyMap.containsKey(ch)){
                frequencyMap.put(ch,frequencyMap.get(ch)+1);
            }else{
                frequencyMap.put(ch,1);
            }
        }

        for(int i=0;i<t.length();i++){  
                char ch = t.charAt(i);
                if(!frequencyMap.containsKey(ch))return false;
                frequencyMap.put(ch,frequencyMap.get(ch)-1);
                if(frequencyMap.get(ch)==0){
                    frequencyMap.remove(ch);
                }
            
        }

        return frequencyMap.isEmpty();
    }
}
