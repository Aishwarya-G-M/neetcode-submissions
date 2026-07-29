class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        int len = tokens.length;
        int computeResult = 0;
        for(int i=0;i<len;i++){
            String str = tokens[i];
            if( isOperator(str) ){
                computeResult = compute(str,stk);
                stk.push(computeResult);
            }else{
                stk.push(Integer.valueOf(str));
            }
        }
        return stk.pop();
    }

    private Integer compute(String str, Deque<Integer> stk){
        Integer num2 = stk.pop();
        Integer num1 = stk.pop();

        switch(str){
            case "+" : return num1+num2;
            case "-" : return num1-num2;
            case "*" : return num1*num2;
            case "/" : return num1/num2;
            default : return 0;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }
}
