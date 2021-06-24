/**
* 迭代法先序遍历
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList();
        LinkedList<Node> stack = new LinkedList<Node>();
        
        LinkedList<Node> cStack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node cur = stack.pop();
            ans.add(cur.val);
            for (Node child : cur.children) {
                cStack.push(child);
            }
            while (!cStack.isEmpty()){
                stack.push(cStack.pop());
            }
            cStack.clear();
        }
        return  ans;
    }
}
