class CQueue {
    Stack<Integer> data;
    Stack<Integer> help;
    public CQueue() {
        data = new Stack<Integer>();
        help = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        data.push(value);
    }
    
    public int deleteHead() {
        int ans =  -1;
        try{
            if(data.peek() == null){
                return ans;
            } 
        }catch(Exception e){
            //nothing
        }


        try{
            while(data.peek() != null){
                help.push(data.pop());
            }
        }catch(Exception e){
            //nothing
        }

        try{
            ans = help.pop();
        }catch(Exception e){
            //nothing
        }

        try{
            while(help.peek() != null){
                data.push(help.pop());
            }
        }catch(Exception e){
            //nothing
            return ans;
        }
        return ans;
    }


}


// class CQueue {
//     Queue <Integer> q;
//     public CQueue() {
//         q = new LinkedList<Integer>();
//     }
    
//     public void appendTail(int value) {
//         q.add(value);
//     }
    
//     public int deleteHead() {
//         Object ans = q.poll();
//         return ans== null  ? -1 : (int)ans ;
//     }


// }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */