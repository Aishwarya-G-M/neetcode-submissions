class MinStack {
    List<Integer> stk;
    List<Integer> minStk;
    int top = -1;
    
    public MinStack() {
        stk = new ArrayList<>();
        minStk = new ArrayList<>();
    }
    
    public void push(int val) {
        int updatedMin = val;
        if(top>-1){
            updatedMin = Math.min(minStk.get(top),val);
        }
        minStk.add(updatedMin);
        stk.add(val);
        top++;
    }
    
    public void pop() {
        // popping the last element;
        stk.remove(top);
        minStk.remove(top);
        top--;
    }
    
    public int top() {
        return stk.get(top);
    }
    
    public int getMin() {
        return minStk.get(top);
    }
}
