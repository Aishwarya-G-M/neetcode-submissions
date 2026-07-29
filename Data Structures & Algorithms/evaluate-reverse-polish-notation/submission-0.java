class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stk = new ArrayDeque<>();
        int len = tokens.length;
        for(int i=0;i<len;i++){
            String str = tokens[i];
            if( str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") ){
                String computeResult = compute(str,stk);
                stk.push(computeResult);
            }else{
                stk.push(str);
            }
        }
        return Integer.valueOf(stk.pop());
    }

    private String compute(String str, Deque<String> stk){
        Integer num2 = Integer.valueOf(stk.pop());
        Integer num1 = Integer.valueOf(stk.pop());

        switch(str){
            case "+" : return String.valueOf(num1+num2);
            case "-" : return String.valueOf(num1-num2);
            case "*" : return String.valueOf(num1*num2);
            case "/" : return String.valueOf(num1/num2);
            default : return "0";
        }
    }
}
