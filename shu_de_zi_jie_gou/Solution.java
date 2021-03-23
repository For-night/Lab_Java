package shu_de_zi_jie_gou;

import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = A;
        queue.add(A);
        while(!queue.isEmpty()){
            cur = queue.poll();

            if(cur.val == B.val){
                if(check(cur , B)){
                    return true;
                }
            }
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
        return false;
        
    }
    public boolean check(TreeNode A , TreeNode B){

        if(A == null || A.val != B.val){
            return false;
        }

        boolean b1 = true , b2 = true;
        
        if(B.left == null){
            b1 = true;
        }else{
            b1 = check(A.left , B.left);
        }

        if(B.right == null){
            b2 = true;
        } else{
            b2 = check(A.right , B.right);
        }

        return b1 & b2;
    }
    
     public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
     }
}

