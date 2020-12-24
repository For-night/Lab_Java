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
        return inOrder(root.left,root.right);
    }
    public static boolean inOrder(TreeNode left,TreeNode right){
        if(left == null){
            return left == right ? true : false;
        }else{
            if(left != right){
                return false;
            }else{
                return inOrder(left.left , right.right) && inOrder(left.right , right.left);
            }
        }
    } 
}
