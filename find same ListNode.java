// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> set = new HashSet<ListNode>();
//         ListNode empNode;
//         empNode = null;
//         if(headA == null || headB == null){
//             return empNode;
//         }
//         set.add(headA);
//         while(headA.next!=null){
//             headA = headA.next;
//             set.add(headA);
//         }
//         while(headB != null){
//             //set.contains(headB) ? return headB :continue ;
//             if(set.contains(headB)){
//                 return headB;
//             }else{
//                 headB = headB.next;
//             }
//         }
//         return empNode;
//     }
// }
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode empNode;
        empNode = null;
        if(headA == null || headB == null){
            return empNode;
        }
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();// 有必要拷贝一份吗？
        int flag = 0;
        n1 = headA;
        n2 = headB;

        while(flag < 2){
            if(n1 == n2){
                return n1;
            }else {
                if(n1.next == null){
                    n1 = headB;
                    flag ++;
                }else{
                    n1 = n1.next;
                }
                if(n2.next == null){
                    n2 = headA;
                    //flag ++;
                }else{
                    n2 = n2.next;
                }
            }
        }
        return empNode;
    }
}
