/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //遇到问题永远都是先分析问题！
 //回溯中会丢弃很多个节点，因为潜在叶节点很多，而我们只要目标的两个或者一个节点

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);

        if(left != null && right != null) return root;
        if(left == null && right == null) return right;
        return left == null ? right : left;
    }
}
