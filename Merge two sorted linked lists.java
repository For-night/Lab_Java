/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//  输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

// 示例1：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4


// class Solution {
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if(l1 == null || l2 == null){
//             return l1 == null ? l2: l1;
//         }

//         if(l1.val < l2.val){
//             ListNode help = l1.next;
//             l1.next = mergeTwoLists(l2,help);
//             return l1;
//         }else{
//             ListNode help = l2.next;
//             l2.next = mergeTwoLists(l1,help);
//             return l2;
//         }
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2: l1;
        }

        if(l1.val < l2.val){
            ListNode help = l1.next;
            ListNode helpR = l1;
            while(help != null && help.val < l2.val){
                help = help .next;
                helpR = helpR.next;
            }
            helpR.next = mergeTwoLists(l2,help);
            return l1;
        }else{
            ListNode help = l2.next;
            ListNode helpR = l2;
            while(help != null && help.val < l2.val){
                help = help .next;
                helpR = helpR.next;
            }
            helpR.next = mergeTwoLists(l1,help);
            return l2;
        }
    }
}

        


