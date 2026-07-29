class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1)return true;
        String trimmedString = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        if(trimmedString.length()<=1)return true;
        for(int i=0;i<=trimmedString.length()/2;i++){
            if(trimmedString.charAt(i) != trimmedString.charAt(trimmedString.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
