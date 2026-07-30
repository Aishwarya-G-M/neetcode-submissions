class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int pos = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(temperatures[stack.peek()]<temperatures[i]){
                while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){       
                    pos = stack.pop(); 
                    result[pos] = i-pos;  
                }  
            }
            stack.push(i);
        }
        return result;
    }
}
