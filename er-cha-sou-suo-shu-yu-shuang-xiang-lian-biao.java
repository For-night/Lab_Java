/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        if(root.left == null){
            if(root.right == null){     // 0 0  左右都空
                lianQiLai(root,root);         
            }else{                      // 0 1  左空右不
                Node ansR = treeToDoublyList(root.right);
                Node endR = ansR.left;
                lianQiLai(root,ansR);
                lianQiLai(endR,root);    
            }
            return root; 
        }else{
            Node ans = treeToDoublyList(root.left);
            Node endL = ans.left;
            if(root.right == null){     // 1 0 左不右空
                lianQiLai(endL , root);
                lianQiLai(root , ans);
            }else{                      // 1 1 左右都有
                Node ansR = treeToDoublyList(root.right);
                Node endR = ansR.left;
                lianQiLai(endL,root);
                lianQiLai(root,ansR);
                lianQiLai(endR,ans);
            }
            return ans;
        }
    }
    public static void lianQiLai(Node n1 , Node n2){
        /*  
        *  n1 -> n2 ; n1 <- n2;
        */
        n1.right = n2;
        n2.left = n1;
    }
}


// 愚蠢的人类！

// class Solution {
//     public Node treeToDoublyList(Node root) {
//         if(root == null) return null;
//         if(root.left == null){
//             if(root.right == null){     // 0 0
//                 root.left = root;
//                 root.right = root;
//                 return root;            
//             }else{                      // 0 1
//                 Node ansR = treeToDoublyList(root.right);
//                 if(ansR.right == ansR){
//                     root.right = ansR;
//                     root.left = ansR;
//                     ansR.left = root;
//                     ansR.right = root;
//                 }else{
//                     root.right = ansR;
//                     ansR.left.right = root;
//                     ansR.left = root;
//                     root.left = ansR.left;             
//                 }
//                 return root; 
//             }
//         }else if(root.right == null){   // 1 0
//             Node ans = treeToDoublyList(root.left);
//             if(ans.right == ans){
//                 root.right = ans;
//                 root.left = ans;
//                 ans.left = root;
//                 ans.right = root;
//             }else{
//                 ans.left.right = root;
//                 root.left = ans.left;
//                 root.right = ans;
//                 ans.left = root;                
//             }
//             return ans;
//         }else{                          // 1 1
//             Node ans = treeToDoublyList(root.left);
//             Node ansR = treeToDoublyList(root.right);
//             if(ans.right == ans){
//                 if(ansR.right == ansR){ //left is 1 ,right is 1
//                     root.right = ansR;
//                     root.left = ans;
//                     ans.left = ansR;
//                     ans.right = root;
//                     ansR.left = root;
//                     ansR.right = ans;
//                 }else{                  //left is 1 ,right is N
//                     root.right = ansR;
//                     root.left = ans;
//                     ans.left = ansR.left;
//                     ans.right = root;
//                     ansR.left.right = ans;
//                     ansR.left = root;
//                 }
//             }else{
//                 if(ansR.right == ansR){ //left is N ,right is 1
//                     ans.left.right = root;       // 1.
//                     root.left = ans.left;        // 2.
//                     root.right = ansR;           // 3.
//                     ansR.right = ans;            // 4.
//                     ans.left = ansR;             // 5.
//                     ansR.left = root;            // 6.
//                 }else{                  //left is N ,right is 1
//                     ans.left.right = root;       // 1.
//                     root.left = ans.left;        // 2.
//                     root.right = ansR;           // 3.
//                     ansR.left.right = ans;       // 4.
//                     ans.left = ansR.left;        // 5.
//                     ansR.left = root;            // 6.
//                 }
//             }
//             return ans;
//         }
//     }
// }



// class Solution {
//     public Node treeToDoublyList(Node root) {
//         if(root.left == null){
//             if(root.right == null){     // 0 0
//                 root.left = root;
//                 root.right = root;
//                 return root;            
//             }else{                      // 0 1
//                 Node ansR = treeToDoublyList(root.right);
//                 root.right = ansR;
//                 ansR.left.right = root;
//                 root.left = ansR.left;
//                 ansR.left = root;
//                 return root;
//             }
//         }else if(root.right == null){   // 1 0
//             Node ans = treeToDoublyList(root.left);
//             ans.left.right = root;
//             root.left = ans.left;
//             root.right = ans;
//             ans.left = root;
//             return ans;
//         }else{                          // 1 1
//             Node ans = treeToDoublyList(root.left);
//             Node ansR = treeToDoublyList(root.right);

//             ans.left.right = root;      // 1.
//             root.left = ans.left.right; // 2.
//             root.right = ansR;          // 3.
//             ansR.left.right = ans;      // 4.
//             ans.left = ansR.left;       // 5.
//             ansR.left = root;           // 6.
//             return ans;
//         }
//     }
// }









