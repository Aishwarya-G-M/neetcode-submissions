class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int pos = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){       
                pos = stack.pop(); 
                result[pos] = i-pos;  
            } 
            stack.push(i);
        }
        return result;
    }
}
