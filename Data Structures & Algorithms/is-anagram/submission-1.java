class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] frequencyArray = new int[26];

        for(int i=0;i<s.length();i++){
            frequencyArray[s.charAt(i)-'a']++;
            frequencyArray[t.charAt(i)-'a']--;
        }

        for(int i : frequencyArray){
            if(i!=0)return false;
        }
        return true;
    }
}
