/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return preOrder(root.left,root.right);
    }
    public static boolean preOrder(TreeNode left,TreeNode right){
        if(left == null){
            //System.out.println( "null left !" );
            return left == right ? true : false;
        }else{
            if (right == null) return false;
            if(left.val != right.val){
                return false;
            }else{
                return (preOrder(left.left , right.right) && preOrder(left.right , right.left));
            }
        }
    } 
}
