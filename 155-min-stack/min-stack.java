class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek())
          minStack.push(val);
    }
    
    public void pop() {
        int popVal=stack.pop();
        if(popVal == minStack.peek())
          minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 /* we use an extra stack to store the val for example consider a eg for 2,1,-3,5,0  are pushed into a stack by means of push operation first 2 is pushed and then 1 is pushed after it checks a condition that 1 is less than 2 and it is push into minstack also . in this way -3 is pushed in both stack and it compares with 1 and push into the minstack also . next the 5 is pushed but it is greater than the -3 so not push in minstack  
 if we perform a gerMin() function we just peek the top value of the minstack and return it .*/ 