class MinStack {
    Stack<Integer> s , help;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();
        help = new Stack<Integer>();
    }
    
    public void push(int x) {
        s.push(x);
        if(help.isEmpty()){
            help.push(x);
        }else if(help.peek() >= x){
            help.push(x);
        }
    }
    
    public void pop() {
        int ache = s.pop();
        if(ache == help.peek()){
            help.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return help.peek();
    }
}
