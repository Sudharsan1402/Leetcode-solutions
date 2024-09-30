class CustomStack {
    int[] stack;
    int maxSize;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
        this.maxSize = maxSize;

        
    }
    
    public void push(int x) {
        if(top >= maxSize-1){
            return;
        }
        top++;
        stack[top] = x;

        
        
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        else{
            return stack[top--];
        }
        
    }
    
    public void increment(int k, int val) {
        if(stack.length < k){
            for(int i=0;i<stack.length;i++){
                stack[i] += val;

            }

        }
        else{
            for(int i=0;i<k;i++){
                stack[i] += val;
            }
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */