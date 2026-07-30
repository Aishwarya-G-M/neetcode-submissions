class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int waitingDayPos = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){       
                waitingDayPos = stack.pop(); 
                result[waitingDayPos] = i-waitingDayPos;  
            } 
            stack.push(i);
        }
        return result;
    }
}
