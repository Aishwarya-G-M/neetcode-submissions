class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' ||ch=='{' ){
                stack.push(ch);
                continue;
            }
            if(stack.size()!=0){
                if(ch==')' && stack.peek()=='('){
                stack.pop();
                continue;
            }
            if(ch=='}' && stack.peek()=='{'){
                stack.pop();
                continue;
            }
            if(ch==']' && stack.peek()=='['){
                stack.pop();
                continue;
            }
            }
            return false;
        }

        if(stack.size()!=0)return false;
        return true;
    }
}
