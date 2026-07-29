class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> resultList = new ArrayList<>();
        int lengthPosStart = 0;
        int lengthPosEnd = 0;
        while(lengthPosStart < str.length()){
            while(lengthPosEnd != str.length() && str.charAt(lengthPosEnd)!='#'){
                lengthPosEnd++;
            }
            int strLength = Integer.valueOf(str.substring(lengthPosStart,lengthPosEnd));
            String decodedStr = str.substring(lengthPosEnd+1,lengthPosEnd+strLength+1);
            resultList.add(decodedStr);
            lengthPosStart = lengthPosEnd+strLength+1;
            lengthPosEnd = lengthPosEnd+strLength+1;
        }
        return resultList;
    }
}
