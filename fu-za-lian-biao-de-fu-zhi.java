/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node ans = new Node(head.val);
        HashMap<Node,Node> hm = new HashMap<Node,Node>();
        Node curAns,curHead;

        curAns = ans;
        curHead = head;
        hm.put(curHead,curAns);
        while(curHead.next != null){
            curHead = curHead.next;
            curAns.next = new Node(curHead.val);
            curAns = curAns.next;
            hm.put(curHead,curAns);
        }

        curAns = ans;
        curHead = head;
        curAns.random = hm.get(curHead.random);
        while(curHead.next != null){
            curHead = curHead.next;
            curAns = curAns.next;
            curAns.random = hm.get(curHead.random);
        }
        return ans;
    }
}
