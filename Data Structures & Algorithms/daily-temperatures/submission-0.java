class Solution {
    class Tuple{
        int temp;
        int day;
        public Tuple(int temp,int day){
            this.day = day;
            this.temp = temp;
        }

        public int getTemp(){
            return this.temp;
        }

        public int getDay(){
            return this.day;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int pos = 0;
        Stack<Tuple> stack = new Stack<>();

        for(int i=0;i<len;i++){
            Tuple tuple = new Tuple(temperatures[i],i);
            if(stack.isEmpty()){
                stack.push(tuple);
                continue;
            }
            Tuple topOfStack = stack.peek();
            if(topOfStack.getTemp()<temperatures[i]){
                while(!stack.isEmpty() && temperatures[i]>topOfStack.getTemp()){       
                    pos = topOfStack.getDay();
                    result[pos] = i-pos;
                    stack.pop();   
                    if(!stack.isEmpty()){
                        topOfStack = stack.peek();
                    }
                }  
            }
            stack.push(tuple);
        }
        return result;
    }
}
