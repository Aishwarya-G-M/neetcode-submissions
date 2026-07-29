class MinStack {
    List<Integer> stk;
    List<Integer> minStk;
    
    public MinStack() {
        stk = new ArrayList<>();
        minStk = new ArrayList<>();
    }
    
    public void push(int val) {
        int updatedMin = val;
        if(!stk.isEmpty()){
            updatedMin = Math.min(minStk.get(stk.size()-1),val);
        }
        minStk.add(updatedMin);
        stk.add(val);
    }
    
    public void pop() {
        stk.remove(stk.size()-1);
        minStk.remove(minStk.size()-1);
    }
    
    public int top() {
        return stk.get(stk.size()-1);
    }
    
    public int getMin() {
        return minStk.get(stk.size()-1);
    }
}
